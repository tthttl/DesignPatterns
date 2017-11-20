package graph.shortestpath.weighted;


import graph.AdjacencyMatrix;
import graph.Graph;
import graph.GraphType;

import java.util.*;

/*
The shortest path algorithm is just a BREADTH FIRST traversal. ==> This creates the distance table, starting from the source.
When traversing the graph, we calculate the distance (and last vertex) of the adjacent vertices IN ADVANCE (by adding the current distance + the weight of the edge).
The trick with the weighted graph is that it can access vertices more than once, and updates their distance if the new one is lower than the stored one.
The shortest path is just reading the elements backwards from the table (accessing the last vertex of the current vertex)
 */
public class Client {

    public static void main(String[] args) {

        AdjacencyMatrix matrix = new AdjacencyMatrix(8, GraphType.DIRECTED);

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

        shortestPath(matrix, 0, 5);

    }

    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {

        //initialize the distanceTable => 1. fill with the vertices (vertex, distanceFromSource, lastVertex) 2. set the source (distance is 0 from itself, lastVertex => itself)
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for (int i = 0; i < graph.getNumOfVertices(); i++) {
            distanceTable.put(i, new DistanceInfo());
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        /*Given the source update the fields in the table, by applying breadthFirstTraversal from source
        Difference:
        1. Queue implementation is important ==> Dijkstra chooses the path with the lowest weight
        ==> 1. The Queue has to store the distance as well, not only the vertex (that's why the queue stores VertexInfos)
        ==> 2. The Queue has to be a priority queue implementation to always choose the lowest weight from the adjacentVertices list.
        2. In order to being able to apply RELAXATION (correct the earlier mistake of the greedy algorithm) it has to be possible to visit the same vertex multiple times.
        ==> When visiting again the distance in the distance table should be updated, if the new distance is less than the existing.
         */
        Queue<VertexInfo> queue = new PriorityQueue<>((v1, v2) -> v1.compareTo(v2));
        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);

        /*
        Now the queue not only stores the vertices, but their distance (compared to the source) as well.
        When we visit the same vertex again, it can be that the new distance is lower then the already stored one.
        This map helps to actualize the queue when needed. (By telling which VertexInfo to remove)
         */
        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        vertexInfoMap.put(source, sourceVertexInfo);

        while (!queue.isEmpty()) {

            VertexInfo currentVertexInfo = queue.remove();
            int current = currentVertexInfo.getVertex();

            for (Integer neighbour : graph.getAdjacentVertices(current)) {

                //Possible to visit the same vertex more times so do not need to check if visited
                //But since the edges are weighted the new distance should be calculated by taking into account the weight as well.
                int neighboursDistance = distanceTable.get(current).getDistance() + graph.getWeightedEdge(current, neighbour);

                //If the new distance is lower ==> Update the result table.
                // + check if the neighbour is already in the queue ==> if yes update that as well.
                // ==> this requires that we keep track of the neighbours VertexInfo in the VertexInfoMap as well
                if (neighboursDistance < distanceTable.get(neighbour).getDistance()) {
                    distanceTable.get(neighbour).setDistance(neighboursDistance);
                    distanceTable.get(neighbour).setLastVertex(current);

                    //maintenance of the queue, if it already holds the neighbour vertex
                    VertexInfo neighboursVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighboursVertexInfo != null){
                        queue.remove(neighboursVertexInfo);
                    }

                    //DEFAULT: adding a NEW neighboursVertexInfo to the queue and to the map (no matter if it existed before or not)
                    neighboursVertexInfo = new VertexInfo(neighbour, neighboursDistance);
                    vertexInfoMap.put(neighbour,neighboursVertexInfo);
                    queue.add(neighboursVertexInfo);
                }
            }
        }
        return distanceTable;
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);
        Stack<Integer> path = new Stack<>();

        path.push(destination);

        int lastVertex = distanceTable.get(destination).getLastVertex();

        while (!(lastVertex == -1 || lastVertex == source)) {
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
