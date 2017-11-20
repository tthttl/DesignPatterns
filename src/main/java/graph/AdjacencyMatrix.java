package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrix implements Graph {

    //the representation of the graph itself
    public int[][] adjacencyMatrix;

    //size of the graph ==> necessary in order to instantiate the array
    public int numOfVertices;
    public GraphType graphType;

    public AdjacencyMatrix(int numOfVertices, GraphType graphType) {
        this.numOfVertices = numOfVertices;
        this.graphType = graphType;

        //instantiate the graph
        adjacencyMatrix = new int[numOfVertices][numOfVertices];

        //initialize by filling it with zeros
        for (int i = 0; i < numOfVertices; i++) {
            for (int k = 0; k < numOfVertices; k++) {
                adjacencyMatrix[i][k] = 0;
            }
        }
    }

    @Override
    public void addEdge(int a, int b) {
        //validity check
        if (a>numOfVertices || a<0 || b>numOfVertices || b<0){
            throw new RuntimeException();
        }

        //set the connection between the two vertices, if its undirected set the reverse connection as well
        adjacencyMatrix[a][b] = 1;
        if(graphType == GraphType.UNDIRECTED){
            adjacencyMatrix[b][a] = 1;
        }
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        if (v1 >= numOfVertices || v2 >= numOfVertices || v1 < 0 || v2 < 0) {
            throw new  IllegalArgumentException("Vertex number is not valid");
        }
        adjacencyMatrix[v1][v2] = weight;
        if(graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = weight;
        }
    }

    @Override
    public int getWeightedEdge(int a, int b) {
        return adjacencyMatrix[a][b];
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        //validity check
        if (vertex>numOfVertices || vertex<0){
            throw new RuntimeException();
        }

        //check if there is a number other than 0 in the matrix for every other vertex, if yes, its an edge..
        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i = 0; i<numOfVertices; i++){
            if (adjacencyMatrix[vertex][i] != 0){
                adjacentVertices.add(i);
            }
        }

        Collections.sort(adjacentVertices);
        return adjacentVertices;
    }

    /*
    Topological sort helper method.
    Topological sort = Every vertex has to come before the vertex it points to. ==> This can be translated into "elements with the lowest inward edges come after each other".
    So we have to know how many inward edges a vertex has. ==> We have to iterate over every element's adjacency list and check whether or not the specified element is present.
     */
    @Override
    public int getInDegree(int vertex) {
        int inDegree = 0;
        for (int i=0; i<numOfVertices; i++){
            if (adjacencyMatrix[i][vertex]!=0){
                inDegree++;
            }
        }
        return inDegree;
    }

    @Override
    public int getNumOfVertices() {
        return numOfVertices;
    }
}
