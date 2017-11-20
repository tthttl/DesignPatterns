package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList implements Graph{

    //The implementation itself is a List of Nodes ==> The Nodes containing a Set of the adjacent vertices each.
    private List<Node> adjacencyList;
    private GraphType graphType;
    public int numOfVertices;

    public AdjacencyList(int numOfVertices, GraphType graphType) {
        this.graphType = graphType;
        this.numOfVertices = numOfVertices;

        adjacencyList = new ArrayList<>();

        for(int i=0; i<numOfVertices; i++){
            adjacencyList.add(new Node(i));
        }

    }

    //Adding is just adding a new element to the Node's adjacentVertices set. (Calling the Node's addEdge method)
    // ==> New vertex cannot be added! All the available vertexes are initialized in the constructor.
    @Override
    public void addEdge(int a, int b) {
        adjacencyList.get(a).addEdge(b);
        if(graphType == GraphType.UNDIRECTED){
            adjacencyList.get(b).addEdge(a);
        }
    }

    //Removing is the same
    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        return adjacencyList.get(vertex).getAdjacentVertices();
    }

    /*
    Topological sort helper method.
    Topological sort = Every vertex has to come before the vertex it points to. ==> This can be translated into "elements with the lowest inward edges come after each other".
    So we have to know how many inward edges a vertex has. ==> We have to iterate over every element's adjacency list and check whether or not the specified element is present.
     */
    @Override
    public int getInDegree(int vertex) {
        int inDegree = 0;
        for(int i=0; i<numOfVertices; i++){
            if (getAdjacentVertices(i).contains(vertex)){
                inDegree++;
            }
        }
        return inDegree;
    }

    @Override
    public int getNumOfVertices() {
        return numOfVertices;
    }

    @Override
    public void addEdge(int a, int b, int weight) {
        throw new RuntimeException("Not implemented..");
    }

    @Override
    public int getWeightedEdge(int a, int b) {
        throw new RuntimeException("Not implemented..");
    }
}
