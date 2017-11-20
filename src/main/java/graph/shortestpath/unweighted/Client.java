package graph.shortestpath.unweighted;


import graph.AdjacencyMatrix;
import graph.Graph;
import graph.GraphType;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.PriorityBlockingQueue;

public class Client {

    public static void main(String[] args) {

        AdjacencyMatrix matrix = new AdjacencyMatrix(5, GraphType.DIRECTED);

        matrix.addEdge(0, 1);
        matrix.addEdge(1, 2);
        matrix.addEdge(2, 3);
        matrix.addEdge(3, 4);

        shortestPath(matrix, 0, 4);

    }

    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {

        //initialize the distanceTable => 1. fill with the vertices (vertex, distanceFromSource, lastVertex) 2. set the source (distance is 0 from itself, lastVertex => itself)
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for (int i = 0; i < graph.getNumOfVertices(); i++) {
            distanceTable.put(i, new DistanceInfo());
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        //Given the source update the -1s in the table, by applying breadthFirstTraversal from source
        Queue<Integer> queue = new PriorityBlockingQueue<>();
        queue.add(source);

        //TRICK
        // 1 ==> When we reach an element we update the distance of its NEIGHBOURS (by adding +1 to the current elements distance) not the elements distance.
        // 2 ==> Then we add the neighbours to the queue so we can continue the breadth first traversal
        while (!queue.isEmpty()) {

            int current = queue.remove();
            // set the distance and lastVertex fields of the neightbour's DistanceInfo 1. if its not set yet 2. by using the current element
            for (Integer neighbour : graph.getAdjacentVertices(current)) {
                int neighboursDistance = distanceTable.get(neighbour).getDistance();
                //we only visit one vertex once ==> if its -1 its not visited yet
                if (neighboursDistance == -1) {
                    neighboursDistance = distanceTable.get(current).getDistance() + 1;
                    distanceTable.get(neighbour).setDistance(neighboursDistance);
                    distanceTable.get(neighbour).setLastVertex(current);
                    //check if the graph continues, if yes add the neighbour element to the queue
                    if (!graph.getAdjacentVertices(neighbour).isEmpty()) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        return distanceTable;
    }

    //iterating through the distance table backwards from destination, always accessing the lastVertex
    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);
        Stack<Integer> path = new Stack<>();

        path.push(destination);

        int lastVertex = distanceTable.get(destination).getLastVertex();

        while (lastVertex != -1 && lastVertex != source) {
            path.push(lastVertex);
            lastVertex = distanceTable.get(lastVertex).getLastVertex();
        }

        if (lastVertex == -1) {
            throw new RuntimeException("No path to the destination");
        }

        System.out.print("Smallest Path is " + source);
        while (!path.isEmpty()) {
            System.out.print("->" + path.pop());
        }
    }

}
