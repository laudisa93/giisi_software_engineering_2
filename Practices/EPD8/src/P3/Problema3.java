/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P3;
import graphs.*;
import java.util.Iterator;
import jss2.*;
/**
 *
 * @author David
 */
public class Problema3 {

    private static Double prim_peso_princi(WAMatrixDirectedGraph grafo, String[] vertice, int pos1, int pos2) {
        Double var = null;
        double peso = grafo.getWeight(vertice[pos1], vertice[pos2]);
        if (peso == 0.) {
            var = 9999.;
        } else {
            var = peso;
        }
        return var;
    }

    private static ArrayUnorderedList<Object> prim_inicio(WAMatrixDirectedGraph grafo, String[] vertice, WAMatrixDirectedGraph grafo2) {
        Double min = 9999.;
        Double var = null;
        UnorderedListADT<Object> arista = new ArrayUnorderedList();
        int pos1 = -1;
        int pos2 = -1;
        int i, j;
        for (i = 0; i < vertice.length; i++) {
            for (j = 0; j < vertice.length; j++) {
                var = prim_peso_princi(grafo, vertice, i, j);
                if (var < min) {
                    min = var;
                    pos1 = i;
                    pos2 = j;
                }
            }
        }
        if (pos1 != -1) {

            arista.addToRear(vertice[pos1]);
            arista.addToRear(vertice[pos2]);

            sacar_grafo(grafo2, vertice[pos1], vertice[pos2], min);

        }
        return (ArrayUnorderedList<Object>) arista;
    }

    private static Double prim_peso_sig(WAMatrixDirectedGraph grafo, String[] vertice, Object o, int pos2) {
        Double var = null;
        double weight = grafo.getWeight(o, vertice[pos2]);
        if (weight == 0.) {
            var = 9999.;
        } else {
            var = weight;
        }
        return var;
    }

    private static boolean prim_sig(WAMatrixDirectedGraph grafo, String[] vertice, ArrayUnorderedList arista, WAMatrixDirectedGraph grafo2) {
        int i = 0, j;
        int pos2 = -1;
        Object o = null;
        Double var = 0., min = 9999.;
        Object[] aux = new Object[arista.size()];

        while (!arista.isEmpty()) {
            aux[i] = arista.removeFirst();
            i++;
        }
        for (i = 0; i < aux.length; i++) {
            arista.addToRear(aux[i]);
        }

        for (i = 0; i < aux.length; i++) {
            for (j = 0; j < vertice.length; j++) {
                var = prim_peso_sig(grafo, vertice, aux[i], j);
                if (var < min && !arista.contains(vertice[j])) {
                    min = var;
                    pos2 = j;
                    o = aux[i];
                }
            }
        }

        if (pos2 != -1) {
            arista.addToRear(vertice[pos2]);

            sacar_grafo_aux(grafo2, o, vertice[pos2], min, arista);
        }

        return (min == 9999.);
    }

    public static ArrayUnorderedList<Object> prim(WAMatrixDirectedGraph grafo, String[] vertice, WAMatrixDirectedGraph grafo2) {
        boolean prbol = false;
        
        ArrayUnorderedList<Object> pr = prim_inicio(grafo, vertice, grafo2);
        do {

            prbol = prim_sig(grafo, vertice, pr, grafo2);
        } while (prbol != true);
        
        return pr;
    }

    private static void sacar_grafo_aux(WAMatrixDirectedGraph grafo, Object o1, Object o2, Double peso, ArrayUnorderedList arista) {
        if (!arista.contains(o1)) {
            grafo.addVertex(o1);
        }
        grafo.addVertex(o2);
        grafo.addEdge(o1, o2, peso);
    }

    private static void sacar_grafo(WAMatrixDirectedGraph grafo, Object o1, Object o2, Double peso) {
        grafo.addVertex(o1);
        grafo.addVertex(o2);
        grafo.addEdge(o1, o2, peso);
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WeightedGraphADT<String> grafo = new WAMatrixDirectedGraph<String>();
        WeightedGraphADT<String> grafo2 = new WAMatrixDirectedGraph<String>();

        String[] vec = new String[6];

        vec[0] = "V1";
        vec[1] = "V2";
        vec[2] = "V3";
        vec[3] = "V4";
        vec[4] = "V5";
        vec[5] = "V6";

        for (int i = 0; i < vec.length; i++) {
            grafo.addVertex(vec[i]);
        }

        grafo.addEdge("V1", "V2", 25);
        grafo.addEdge("V2", "V5", 10);
        grafo.addEdge("V5", "V1", 30);
        grafo.addEdge("V1", "V3", 20);
        grafo.addEdge("V3", "V4", 30);
        grafo.addEdge("V4", "V5", 15);
        grafo.addEdge("V5", "V6", 8);

        ArrayUnorderedList di = prim((WAMatrixDirectedGraph) grafo, vec, (WAMatrixDirectedGraph) grafo2);

        System.out.println("Nodos marcados");
        Iterator it = di.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");

        }

        System.out.print("\n" + grafo2);
    }
}
