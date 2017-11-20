package graph;

import java.util.*;

public class Node {

    private int vertex;
    private Set<Integer> adjacentVertices = new HashSet<>();

    public Node(int vertex) {
        this.vertex = vertex;
    }

    public int getVertex() {
        return vertex;
    }

    public List<Integer> getAdjacentVertices() {
        List<Integer> adjVertList = new ArrayList<>(adjacentVertices);
        Collections.sort(adjVertList);
        return adjVertList;
    }

    public void addEdge(int vertex){
        adjacentVertices.add(vertex);
    }
}
