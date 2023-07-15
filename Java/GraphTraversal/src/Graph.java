
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private ArrayList<ArrayList<Integer>> adjacencyList;
    private boolean[] visited;


    public Graph(int numberOfVertices) {
        this.adjacencyList = new ArrayList<>(numberOfVertices);
        this.visited = new boolean[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public Graph(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
        this.adjacencyList = adjacencyList;
        this.visited = visited;
    }

    public void addEdge(int startVertex, int endVertex) {
        adjacencyList.get(startVertex).add(endVertex);
        adjacencyList.get(endVertex).add(startVertex);
    }

    public void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Integer current = queue.element();
            queue.remove();
            System.out.print(current + " ");
            for (Integer neighbour : adjacencyList.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int vertex) {
       visited[vertex] = true;
        System.out.print(vertex + " ");
        for (Integer neighbour : adjacencyList.get(vertex)) {
            if (!visited[neighbour]) {
                dfs(neighbour);
            }
        }
    }

    public int findNumberOfComponents(int numberOfVertices) {
        int components = 0;
        for (int i = 0; i < numberOfVertices; i++) {
            if (!visited[i]) {
                dfs(i);
                components++;
            }
        }
        return components;
    }

    public void clearVisited() {
        Arrays.fill(visited, false);
    }

    public static void main(String[] args) {
        int numberOfVertices = 8;
        Graph graph = new Graph(numberOfVertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 7);
        graph.addEdge(3, 6);
        graph.addEdge(7, 4);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        System.out.println("Graph BFS:");
        graph.bfs(7);
        graph.clearVisited();

        System.out.println("Graph DFS:");
        graph.dfs(7);
        System.out.println();
        graph.clearVisited();

        System.out.println("Graph Number of components: " + graph.findNumberOfComponents(numberOfVertices));
        graph.clearVisited();
    }
}
