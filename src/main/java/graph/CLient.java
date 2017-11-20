package graph;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Client {

    public static void main(String[] args) {

        AdjacencyMatrix matrix = new AdjacencyMatrix(5, GraphType.UNDIRECTED);

        matrix.addEdge(0, 1);
        matrix.addEdge(1, 2);
        matrix.addEdge(2, 3);
        matrix.addEdge(3, 4);
        matrix.addEdge(2, 4);

        matrix.getAdjacentVertices(2).forEach(System.out::println);
        //for loop is necessary because the graph may be unconnected ==> we start the traversal at every vertex
        for (int i = 0; i < matrix.numOfVertices; i++) {
            depthFirstTraversal(matrix, new boolean[matrix.numOfVertices], i);
            System.out.println();
        }

        System.out.println();

        AdjacencyList adjacencyList = new AdjacencyList(5, GraphType.DIRECTED);

        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(3, 4);


        for (int i = 0; i < adjacencyList.numOfVertices; i++) {
            breadthFirstTraversal(adjacencyList, new boolean[adjacencyList.numOfVertices], i);
            System.out.println();
        }

        System.out.println();

        matrix.getAdjacentVertices(2).forEach(System.out::println);

        System.out.println("Topological sort: ");
        topologicalSort(adjacencyList).forEach(System.out::print);

    }

    //same as in heap, depthFirst is called recursively for the adjacentVertices("child nodes")
    public static void depthFirstTraversal(Graph graph, boolean[] visited, int vertex) {

        //EXIT condition and makes sure to avoid cycles
        if (visited[vertex]) {
            return;
        }

        visited[vertex] = true;

        //depth first is going down to the bottom and coming back up level by level ==> adjacent vertices are the "child nodes" of a graph
        List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);

        for (Integer element : adjacentVertices) {
            depthFirstTraversal(graph, visited, element);
        }

        System.out.print(vertex + " -> ");
    }

    //breadth first is going from the top level by level ==> while loop (dequeue the next, print, then enqueue its neighbours)
    public static void breadthFirstTraversal(Graph graph, boolean[] visited, int vertex) {

        Queue<Integer> queue = new PriorityBlockingQueue<>();

        queue.add(vertex);

        while (!queue.isEmpty()) {

            int current = queue.remove();

            if (visited[current]) {
                continue;
            }

            visited[current] = true;

            System.out.print(current);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(current);

            adjacentVertices.forEach(element -> {
                if (!visited[element]) {
                    queue.add(element);
                }
            });
        }
    }

    /*
    Topological means ==> The vertex which points to an other vertex should come before the vertex which it points to. ==>
    That translates to that smaller number of incoming edges comes before larger. ==> Start at vertex with 0 incoming edge (inDegree).
    If there is no vertex with 0 inDegree it means the graph has a cycle and this sort is only possible when there is no cycle!!
    After sorting the vertex with 0 ==> REMOVE this vertex, then continue with the next 0.
     */
    public static List<Integer> topologicalSort(Graph graph) {
        /*It is possible to have multiple topological sort in a graph so it is not possible to store the elements with 0 inDegree in the result List right away.
        This will hold the elements until they are transferred from here to the result List one by one.
         */
        Queue<Integer> elementsWithZeroIndegree = new PriorityBlockingQueue<>();
        /*
        Since every step involves checking for 0 and THEN removing the element from the others inDegree,
        we need to keep track of every elements continuously reducing inDegree count.
         */
        Map<Integer, Integer> inDegreePerVertex = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int vertex = 0; vertex<graph.getNumOfVertices(); vertex++){
            int inDegree = graph.getInDegree(vertex);
            inDegreePerVertex.put(vertex, inDegree);
            if (inDegree == 0){
                elementsWithZeroIndegree.add(vertex);
            }
        }

        while (!elementsWithZeroIndegree.isEmpty()){

            int next = elementsWithZeroIndegree.remove();

            result.add(next);

            List<Integer> adjacentVertices =  graph.getAdjacentVertices(next);

            for (Integer neighbour : adjacentVertices){
                int reducedInDegreeOfNeighbour = inDegreePerVertex.get(neighbour) - 1;
                inDegreePerVertex.remove(neighbour);
                inDegreePerVertex.put(neighbour, reducedInDegreeOfNeighbour);

                if(reducedInDegreeOfNeighbour == 0){
                    elementsWithZeroIndegree.add(neighbour);
                }
            }
        }

        //If there is a loop there will be a stackOverflow before this, but this can filter out the UNDIRECTED graphs,
        //where there is no element with 0 inDegree ==> TopSort only possible in DIRECTED acyclic graphs.
        if (result.size() != graph.getNumOfVertices()){
            throw new RuntimeException("Not a DAG!");
        }

        return result;
    }

    public List<Integer> topSortPractice(Graph graph){

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> indegreePerVertex = new HashMap<>();
        Queue<Integer> elementsWithZeroIndices = new PriorityQueue<>();

        for (int i = 0; i<graph.getNumOfVertices(); i++){
            int indegree = graph.getInDegree(i);
            indegreePerVertex.put(i,indegree);
            if (indegree == 0){
                elementsWithZeroIndices.add(i);
            }
        }

        while (!elementsWithZeroIndices.isEmpty()){

            int current = elementsWithZeroIndices.remove();

            result.add(current);

            for (Integer neighbour: graph.getAdjacentVertices(current)){
                int reducedIndegree = graph.getInDegree(neighbour);
                indegreePerVertex.remove(neighbour);
                indegreePerVertex.put(neighbour,reducedIndegree);

                if (reducedIndegree == 0){
                    elementsWithZeroIndices.add(neighbour);
                }
            }

            if (result.size() != graph.getNumOfVertices()){
                throw new RuntimeException("Not a DAG!");
            }
        }
        return result;
    }

}
