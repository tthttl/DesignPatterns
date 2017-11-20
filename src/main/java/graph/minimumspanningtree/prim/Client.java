package graph.minimumspanningtree.prim;


import graph.AdjacencyMatrix;
import graph.Graph;
import graph.GraphType;

import java.util.*;


public class Client {

    public static void main(String[] args) {
        AdjacencyMatrix matrix = new AdjacencyMatrix(8, GraphType.UNDIRECTED);

        matrix.addEdge(2, 7, 4);
        matrix.addEdge(0, 3, 2);
        matrix.addEdge(0, 4, 2);
        matrix.addEdge(0, 1, 1);
        matrix.addEdge(2, 1, 3);
        matrix.addEdge(1, 3, 2);
        matrix.addEdge(3, 5, 1);
        matrix.addEdge(3, 6, 3);
        matrix.addEdge(4, 7, 2);
        matrix.addEdge(7, 5, 4);

        spanningTree(matrix, 7);

    }


    //Nincs k�t method, egyben �p�tj�k a distance table-t �s a spanningTree setet, amit azt�n ki is nyomtatunk
    private static void spanningTree(Graph graph, int source) {

        Map<Integer, DistanceTableData> distanceTable = new HashMap<>();
        for (int i = 0; i < graph.getNumOfVertices(); i++) {
            distanceTable.put(i, new DistanceTableData());
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Queue<VertexInfo> queue = new PriorityQueue<>((v1, v2) -> v1.compareTo(v2));
        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        vertexInfoMap.put(source, sourceVertexInfo);


        //DIFFERENCE: +2 set ---------------------------------------------------
        Set<String> spanningTree = new HashSet<>();
        Set<Integer> visitedVertices = new HashSet<>();

        while (!queue.isEmpty()) {

            VertexInfo currentVertexInfo = queue.remove();
            int current = currentVertexInfo.getVertex();

            if (visitedVertices.contains(current)) {
                continue;
            }

            visitedVertices.add(current);
            //itt nem a t�bla lesz a v�g�n a helyes, hanem a queue-ban lesznek a legr�videbb distancot tartalmaz� vertexek
            if (current != source) {
                String newEdge = String.valueOf(distanceTable.get(current).getLastVertex()) + " -> " + String.valueOf(current);
                if (!spanningTree.contains(newEdge)) {
                    spanningTree.add(newEdge);
                }
            }

        //DIFFERENCE: END ---------------------------------------------------

            for (Integer neighbour : graph.getAdjacentVertices(current)) {
                /*A current distancot nem kell hozz�adni, mert csak az adott vertext�l sz�m�tott t�vols�g �rdekes, itt most a t�bla
                csak azt vizsg�lja, hogy egy vertex el�r�s�hez melyik vertext�l vezet a legr�videbb �t, nem azt, hogy melyik vertexen kereszt�l
                lenne a legrovidebb az �t a forr�st�l, mert itt nincs forr�s, b�rhonnan indulhatn�nk, csak az a l�nyeg, hogy �rints�nk minden vertexet!
                 */

                int newDistanceToNeighbour = graph.getWeightedEdge(current, neighbour);

                if (newDistanceToNeighbour < distanceTable.get(neighbour).getDistance()) {
                    distanceTable.get(neighbour).setDistance(newDistanceToNeighbour);
                    distanceTable.get(neighbour).setLastVertex(current);

                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null) {
                        queue.remove(neighbourVertexInfo);
                    }
                    neighbourVertexInfo = new VertexInfo(neighbour, newDistanceToNeighbour);
                    queue.add(neighbourVertexInfo);
                    vertexInfoMap.put(neighbour, neighbourVertexInfo);
                }
            }
        }

        spanningTree.forEach(edge -> {
            System.out.print(edge);
            System.out.println();
        });

    }


}
