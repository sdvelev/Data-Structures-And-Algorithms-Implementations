import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Prim {

    private List<List<Map.Entry<Integer, Integer>>> graph;
    private List<Integer> minEdge;
    private List<Boolean> visited;
    private List<Integer> parent;

    public Prim(int numberOfVertices) {
        this.graph = new ArrayList<>(numberOfVertices);

        for (int i = 0; i < numberOfVertices; i++) {
            this.graph.add(new ArrayList<>());
        }
        this.minEdge = new ArrayList<>();
        this.visited = new ArrayList<>();
        this.parent = new ArrayList<>();
    }

    public void addEdge(int starVertex, int endVertex, int price) {
        this.graph.get(starVertex).add(Map.entry(endVertex, price));
        this.graph.get(endVertex).add(Map.entry(starVertex, price));
    }

    public int prim(int vertex) {

        for (int i = 0; i < graph.size(); i++) {
            minEdge.add(i, Integer.MAX_VALUE);
            visited.add(false);
            parent.add(i);
        }

        minEdge.set(vertex, 0);

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByKey());
        queue.add(Map.entry(0, vertex));

        while (!queue.isEmpty()) {
            int distanceToCurrentVertex = queue.peek().getKey();
            int currentVertex = queue.peek().getValue();
            queue.remove();
            visited.set(currentVertex, true);

//            if (distanceToCurrentVertex > minEdge.get(currentVertex)) {
//                continue;
//            }

            for (Map.Entry<Integer, Integer> neighbour : this.graph.get(currentVertex)) {

                int neighbourVertex = neighbour.getKey();
                int neighbourPrice = neighbour.getValue();

                if (minEdge.get(neighbourVertex) > neighbourPrice && !visited.get(neighbourVertex)) {
                    minEdge.set(neighbourVertex, neighbourPrice);
                    parent.set(neighbourVertex, currentVertex);
                    queue.add(Map.entry(minEdge.get(neighbourVertex), neighbourVertex));
                }
            }
        }
        int minSpanningTreeSum = 0;
        for (int i = 0; i < this.minEdge.size(); i++) {
            minSpanningTreeSum += minEdge.get(i);
        }
        return minSpanningTreeSum;
    }

    public static void main(String[] args) {
        int numberOfVertices = 6;
        Prim graph = new Prim(numberOfVertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 5);
        graph.addEdge(2, 5, 2);
        graph.addEdge(0, 4, 3);
        graph.addEdge(0, 5, 3);
        graph.addEdge(1, 4, 1);
        graph.addEdge(1, 5, 1);

        System.out.println(graph.prim(0));
        System.out.println(graph.minEdge);
        System.out.println(graph.parent);
    }

}
