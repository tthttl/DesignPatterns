package graph.shortestpath.weighted;

public class VertexInfo implements Comparable {

    private int vertex;
    private int distance;

    public VertexInfo(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public int getVertex() {
        return vertex;
    }

    public int getDistance() {
        return distance;
    }

    //Because the priority queue has to decide which vertex has the lowest distance!
    @Override
    public int compareTo(Object o) {
        VertexInfo vertexInfo = (VertexInfo) o;
        if (this.distance - vertexInfo.getDistance() > 0) {
            return 1;
        }
        if (this.distance - vertexInfo.getDistance() == 0) {
            return 0;
        }
        return -1;
    }
}
