/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P1;
import graphs.*;
import java.util.Iterator;
import jss2.*;
/**
 *
 * @author David
 */
public class Problema1 {

    
    private static int buscar_posicion(WAMatrixDirectedGraph grafo, Double[] v, ArrayUnorderedList arista, String[] vertice) {
        int i, j = 0;
        Double min = 9999.;
        for (i = 0; i < v.length; i++) {
            if (v[i] < min && !arista.contains(vertice[i])) {
                min = v[i];
                j = i;
            }
        }
        return j;

    }

    private static Double[] vector_dijkstra_nodo(WAMatrixDirectedGraph grafo, String[] vertice, int pos) {
        Double[] res = new Double[vertice.length];
        for (int i = 0; i < vertice.length; i++) {
            double peso = grafo.getWeight(vertice[pos], vertice[i]);
            if (peso == 0. && !vertice[pos].equals(vertice[i])) {
                res[i] = 9999.;
            } else {
                res[i] = peso;
            }
        }

        return res;
    }

    private static Double[] vector_dijkstra_aux(WAMatrixDirectedGraph grafo, String[] vertice, int pos, Double[] disjkstraux) {
        Double[] res = new Double[vertice.length];
        for (int i = 0; i < vertice.length; i++) {
            double peso = grafo.getWeight(vertice[pos], vertice[i]);
            if (peso != 0.) {
                if (disjkstraux[i] < peso+disjkstraux[pos]) {
                    res[i] = disjkstraux[i];
                } else {
                    res[i] = peso+disjkstraux[pos];
                }
            }
            if (res[i] == null) {
                res[i] = disjkstraux[i];
            }
        }

        return res;
    }

    public static Double[] dijkstra(WAMatrixDirectedGraph grafo, String[] vertice, int pos) {
        ArrayUnorderedList arista = new ArrayUnorderedList();
        arista.addToRear(vertice[pos]);
        Double[] vectordijkstra = vector_dijkstra_nodo((WAMatrixDirectedGraph) grafo, vertice, pos);
        for (int i = 0; i < vertice.length - 1; i++) {
            pos = buscar_posicion((WAMatrixDirectedGraph) grafo, vectordijkstra, arista, vertice);
            arista.addToRear(vertice[pos]);
            vectordijkstra = vector_dijkstra_aux((WAMatrixDirectedGraph) grafo, vertice, pos, vectordijkstra);
        }

        return vectordijkstra;

    }
    public static void main(String[] args) {
        WeightedGraphADT<String> grafo = new WAMatrixDirectedGraph<String>();
        

        String[] vertice = new String[5];
        vertice[0] = "V1";
        vertice[1] = "V2";
        vertice[2] = "V3";
        vertice[3] = "V4";
        vertice[4] = "V5";
        int inicio=0;

        for (int i = 0; i < vertice.length; i++) {
            grafo.addVertex(vertice[i]);
        }

        grafo.addEdge("V1", "V2", 2);
        grafo.addEdge("V1", "V5", 3);
        grafo.addEdge("V1", "V3", 1);
        grafo.addEdge("V2", "V4", 4);
        grafo.addEdge("V4", "V1", 1);
        grafo.addEdge("V4", "V3", 3);
        grafo.addEdge("V4", "V5", 5);
        grafo.addEdge("V3", "V2", 1);
        grafo.addEdge("V3", "V5", 1);


        Double[] dijkstra = dijkstra((WAMatrixDirectedGraph) grafo, vertice, inicio);
        System.out.println("Muestra la tabla de distra desde "+ vertice[inicio]);
        for (int i = 0; i <dijkstra.length; i++) {
            System.out.print(dijkstra[i]+", ");
        }
        
    
    }
}
