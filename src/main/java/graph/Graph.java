package graph;

import java.util.List;

public interface Graph {

    void addEdge (int a, int b);
    void addEdge (int a, int b, int weight);
    int getWeightedEdge(int a, int b);
    List<Integer> getAdjacentVertices(int vertex);
    int getInDegree(int vertex);
    int getNumOfVertices();

}
