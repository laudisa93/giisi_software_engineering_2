/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2;

import graphs.*;
import java.util.Iterator;
import jss2.*;
/**
 *
 * @author David
 */
public class Problema2 {

    private static Double Kruskalweightinicio(WAMatrixDirectedGraph grafo, String[] vertice, int pos1, int pos2) {
        Double var = null;
        double peso = grafo.getWeight(vertice[pos1], vertice[pos2]);
        if (peso == 0.) {
            var = 9999.;
        } else {
            var = peso;
        }
        return var;
    }

    private static ArrayUnorderedList<Object> Kruskalinicio(WAMatrixDirectedGraph grafo, String[] vertice, WAMatrixDirectedGraph grafo2) {
        Double min = 9999.;
        Double var = null;
        UnorderedListADT<Object> arista = new ArrayUnorderedList<Object>();
        int pos1 = -1;
        int pos2 = -1;
        int i, j;
        for (i = 0; i < vertice.length; i++) {
            for (j = 0; j < vertice.length; j++) {
                var = Kruskalweightinicio(grafo, vertice, i, j);
                if (var < min) {
                    min = var;
                    pos1 = i;
                    pos2 = j;
                }
            }
        }
        if (pos1 != -1) {

            arista.addToFront(vertice[pos1]);
            arista.addToRear(vertice[pos2]);

            sacar_grafo(grafo2, vertice[pos1], vertice[pos2], min);

        }
        return (ArrayUnorderedList<Object>) arista;
    }

    public static ArrayUnorderedList<Object> Kruskal(WAMatrixDirectedGraph grafo, String[] vertice, WAMatrixDirectedGraph grafo2) {

        ArrayUnorderedList<Object> principio = Kruskalinicio((WAMatrixDirectedGraph) grafo, vertice, (WAMatrixDirectedGraph) grafo2);
        UnorderedListADT<Object> kfinal = new ArrayUnorderedList<Object>();
        UnorderedListADT<Object> solu = new ArrayUnorderedList<Object>();
        kfinal.addToRear(principio.removeLast());

        boolean bol = false;
        do {
            bol = Kruskal_avance(grafo, vertice, grafo2, principio, (ArrayUnorderedList) kfinal);
        } while (bol != true);
        while(!principio.isEmpty()){
        solu.addToFront(principio.removeLast());
        solu.addToRear(kfinal.removeLast());
        }
        return(ArrayUnorderedList<Object>) solu;
    }

    private static boolean Kruskal_avance(WAMatrixDirectedGraph grafo, String[] vec, WAMatrixDirectedGraph grafo2, ArrayUnorderedList kprincipio, ArrayUnorderedList kfinal) {
        Double min = 9999.;
        Double var = null;
        int pos1 = -1;
        int pos2 = -1;
        int i, j;
        for (i = 0; i < vec.length; i++) {
            for (j = 0; j < vec.length; j++) {
                var = Kruskalweightinicio(grafo, vec, i, j);
                if (var < min && !(kprincipio.contains(vec[j]) && kfinal.contains(vec[i])) && !(kprincipio.contains(vec[i]) && kfinal.contains(vec[j]))) {
                    min = var;
                    pos1 = i;
                    pos2 = j;
                }

            }
        }
        if (pos1 != -1) {
            kprincipio.addToRear(vec[pos1]);
            kfinal.addToRear(vec[pos2]);

            sacar_grafo_aux(grafo2, vec[pos1], vec[pos2], min, kprincipio, kfinal);
        }

        return (min == 9999.);
    }

    private static void sacar_grafo(WAMatrixDirectedGraph grafo, Object o1, Object o2, Double peso) {
        grafo.addVertex(o1);
        grafo.addVertex(o2);
        grafo.addEdge(o1, o2, peso);
    }

    private static void sacar_grafo_aux(WAMatrixDirectedGraph grafo, Object o1, Object o2, Double peso, ArrayUnorderedList<Object> kprincipio, ArrayUnorderedList<Object> kfinal) {

        int cont1 = 0, cont2 = 0;
        Iterator<Object> it1 = kprincipio.iterator();
        Iterator<Object> it2 = kfinal.iterator();
        while (it1.hasNext()) {
            Object oaux1 = it1.next();
            Object oaux2 = it2.next();
            if (o1.equals(oaux1) || o1.equals(oaux2)) {
                cont1++;
            }
            if (o2.equals(oaux1) || o2.equals(oaux2)) {
                cont2++;
            }
        }
        if (cont1 == 1) {
            grafo.addVertex(o1);
        }
        if (cont2 == 1) {
            grafo.addVertex(o2);
        }
        grafo.addEdge(o1, o2, peso);
    }
    public static void main(String[] args) {
        
        WeightedGraphADT<String> grafo = new WAMatrixDirectedGraph<String>();
        WeightedGraphADT<String> grafo2 = new WAMatrixDirectedGraph<String>();

        String[] vertice = new String[6];
        ArrayUnorderedList<Double> arista = new ArrayUnorderedList<Double>();
        int i, j, k = 0;

        vertice[0] = "V1";
        vertice[1] = "V2";
        vertice[2] = "V3";
        vertice[3] = "V4";
        vertice[4] = "V5";
        vertice[5] = "V6";

        for (i = 0; i < vertice.length; i++) {
            grafo.addVertex(vertice[i]);
        }


        grafo.addEdge("V1", "V2", 25);
        grafo.addEdge("V2", "V5", 10);
        grafo.addEdge("V5", "V1", 30);
        grafo.addEdge("V1", "V3", 20);
        grafo.addEdge("V3", "V4", 30);
        grafo.addEdge("V4", "V5", 15);
        grafo.addEdge("V5", "V6", 8);

        ArrayUnorderedList<Object> kruskal = Kruskal((WAMatrixDirectedGraph) grafo, vertice, (WAMatrixDirectedGraph) grafo2);

        System.out.println("Orden de las aristas");
        while(!kruskal.isEmpty()){
            System.out.println(kruskal.removeFirst()+" "+kruskal.removeLast());
        }

        System.out.println(grafo2);
    }
}
