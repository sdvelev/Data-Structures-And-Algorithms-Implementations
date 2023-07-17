import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private List<List<Integer>> graph;
    private List<Integer> dist;

    public BFS(int numberOfVertices) {
        this.graph = new ArrayList<>(numberOfVertices);

        for (int i = 0; i < numberOfVertices; i++) {
            this.graph.add(new ArrayList<>());
        }
        this.dist = new ArrayList<>();
    }

    public void addEdge(int starVertex, int endVertex) {
        this.graph.get(starVertex).add(endVertex);
        this.graph.get(endVertex).add(starVertex);
    }

    public void bfs(int vertex) {

        for (int i = 0; i < graph.size(); i++) {
            dist.add(i, Integer.MAX_VALUE);
        }

        dist.set(vertex, 0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.peek();
            queue.remove();

            for (Integer neighbour : this.graph.get(currentVertex)) {

                if (dist.get(neighbour) > dist.get(currentVertex) + 1) {
                    dist.set(neighbour, dist.get(currentVertex) + 1);
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        int numberOfVertices = 6;
        BFS graph = new BFS(numberOfVertices);

        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);

        graph.bfs(0);

        System.out.println(graph.dist);
    }

}
