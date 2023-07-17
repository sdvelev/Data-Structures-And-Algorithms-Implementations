import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

    private List<List<Map.Entry<Integer, Integer>>> graph;
    private List<Integer> dist;

    public Dijkstra(int numberOfVertices) {
        this.graph = new ArrayList<>(numberOfVertices);

        for (int i = 0; i < numberOfVertices; i++) {
            this.graph.add(new ArrayList<>());
        }
        this.dist = new ArrayList<>();
    }

    public void addEdge(int starVertex, int endVertex, int price) {
        this.graph.get(starVertex).add(Map.entry(endVertex, price));
        this.graph.get(endVertex).add(Map.entry(starVertex, price));
    }

    public void dijkstra(int vertex) {

        for (int i = 0; i < graph.size(); i++) {
            dist.add(i, Integer.MAX_VALUE);
        }

        dist.set(vertex, 0);

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByKey());
        queue.add(Map.entry(0, vertex));

        while (!queue.isEmpty()) {
            int distanceToCurrentVertex = queue.peek().getKey();
            int currentVertex = queue.peek().getValue();
            queue.remove();

            if (distanceToCurrentVertex > dist.get(currentVertex)) {
                continue;
            }

            for (Map.Entry<Integer, Integer> neighbour : this.graph.get(currentVertex)) {

                int neighbourVertex = neighbour.getKey();
                int neighbourPrice = neighbour.getValue();

                if (dist.get(neighbourVertex) > distanceToCurrentVertex + neighbourPrice) {
                    dist.set(neighbourVertex, distanceToCurrentVertex + neighbourPrice);
                    queue.add(Map.entry(dist.get(neighbourVertex), neighbourVertex));
                }
            }
        }
    }

    public static void main(String[] args) {
        int numberOfVertices = 9;
        Dijkstra graph = new Dijkstra(numberOfVertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(7, 8, 7);
        graph.addEdge(7, 6, 1);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 5, 4);
        graph.addEdge(8, 6, 6);
        graph.addEdge(6, 5, 2);
        graph.addEdge(5, 3, 14);
        graph.addEdge(5, 4, 10);
        graph.addEdge(3 ,4, 9);

        graph.dijkstra(0);

        System.out.println(graph.dist);
    }
}
