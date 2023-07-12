
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeImpl {

    private List<Integer>[] tree;

    public TreeImpl(int n) {
        this.tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            this.tree[i] = new ArrayList<>();
        }
    }

    public void insert(int parent, int child) {
        tree[parent].add(child);
    }

    public void dfs(int v) {
        System.out.println(v);

        for (int x : tree[v]) {
            dfs(x);
        }
    }

    public void bfs(int v) {
        Queue<Integer> printQueue = new ArrayDeque<>();
        printQueue.add(v);
        while (!printQueue.isEmpty()) {
            int frontElement = printQueue.element();
            printQueue.remove();
            System.out.println(frontElement);

            for (int neighbour : tree[frontElement]) {
                printQueue.add(neighbour);
            }
        }
    }

    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl(100);
        tree.insert(1, 2);
        tree.insert(1, 4);
        tree.insert(1, 7);
        tree.insert(7, 8);
        tree.insert(8, 9);
        tree.insert(2, 6);
        tree.insert(7, 99);

        System.out.println("DFS:");
        tree.dfs(1);

        System.out.println("BFS:");
        tree.bfs(1);
    }
}
