import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DAG {

    private ArrayList<ArrayList<Integer>> adjacencyList;
    private boolean[] visited;
    private int numberOfVertices;
    private Stack<Integer> stack;

    public DAG(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.visited = new boolean[numberOfVertices];

        this.adjacencyList = new ArrayList<>(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
        this.stack = new Stack<>();
    }

    public void addEdge(int startVertex, int endVertex) {
        adjacencyList.get(startVertex).add(endVertex);
    }

    public void clearVisited() {
        Arrays.fill(visited, false);
    }

    public void clearStack() {
        this.stack.clear();
    }
    private void dfs(int vertex) {
        visited[vertex] = true;

        for (Integer neighbour : adjacencyList.get(vertex)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                dfs(neighbour);
            }
        }
        stack.push(vertex);
    }

    private void printStackReverse() {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public void topologicalSorting() {
        for (int i = 0; i < numberOfVertices; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        printStackReverse();
        clearStack();
    }

    public static void main(String[] args) {
        DAG dag = new DAG(8);
        dag.addEdge(0, 1);
        dag.addEdge(0, 2);
        dag.addEdge(1, 4);
        dag.addEdge(2, 7);
        dag.addEdge(3, 6);
        dag.addEdge(7, 4);
        dag.addEdge(5, 7);
        dag.addEdge(6, 7);

        System.out.println("DAG Topological sorting:");
        dag.topologicalSorting();
        dag.clearVisited();
    }


}
