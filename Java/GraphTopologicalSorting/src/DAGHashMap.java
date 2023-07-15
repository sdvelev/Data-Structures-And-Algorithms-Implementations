import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DAGHashMap {

    private Map<Integer, List<Integer>> adjacencyList;
    private Map<Integer, Boolean> visited;
    private Stack<Integer> stack;

    public DAGHashMap() {
        this.adjacencyList = new HashMap<>();
        this.visited = new HashMap<>();
        this.stack = new Stack<>();
    }

    public void addEdge(int startVertex, int endVertex) {
        adjacencyList.putIfAbsent(startVertex, new ArrayList<>());
        adjacencyList.get(startVertex).add(endVertex);
    }

    public void clearVisited() {
        this.visited.clear();
    }

    public void clearStack() {
        this.stack.clear();
    }
    private void dfs(int vertex) {
        visited.put(vertex, true);

        List<Integer> neighboursList = adjacencyList.get(vertex);
        if (neighboursList != null) {
            for (Integer neighbour : adjacencyList.get(vertex)) {
                if (!visited.containsKey(neighbour) || !visited.get(neighbour)) {
                    visited.put(neighbour, true);
                    dfs(neighbour);
                }
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
        for (Integer currentVertex : adjacencyList.keySet()) {
            if (!visited.containsKey(currentVertex) || !visited.get(currentVertex)) {
                dfs(currentVertex);
            }
        }
        printStackReverse();
        clearStack();
    }

    public static void main(String[] args) {
        DAGHashMap dag = new DAGHashMap();
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
