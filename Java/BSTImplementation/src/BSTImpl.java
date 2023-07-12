import java.util.ArrayDeque;
import java.util.Queue;

public class BSTImpl {

    private static class Node {
        public int key;
        public Node left;
        public Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    public void printInorder() {
        System.out.println("Inorder Print:");
        inorder(root);
    }

    public void printPreorder() {
        System.out.println("Preorder Print:");
        preorder(root);
    }

    public void printPostorder() {
        System.out.println("Postorder Print:");
        postorder(root);
    }

    public void printBFS() {
        System.out.println("Breadth First Search:");
        bfs(root);
    }

    private Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    private void inorder(Node current) {
        if (current != null) {
            inorder(current.left);
            System.out.println(current.key);
            inorder(current.right);
        }
    }

    private void preorder(Node current) {
        if (current != null) {
            System.out.println(current.key);
            preorder(current.left);
            preorder(current.right);
        }
    }

    private void postorder(Node current) {
        if (current != null) {
            postorder(current.left);
            postorder(current.right);
            System.out.println(current.key);
        }
    }

    private void bfs(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> printQueue = new ArrayDeque<>();
        printQueue.add(root);
        while (!printQueue.isEmpty()) {
            Node firstElement = printQueue.element();
            printQueue.remove();
            System.out.println(firstElement.key);
            if (firstElement.left != null) {
                printQueue.add(firstElement.left);
            }
            if (firstElement.right != null) {
                printQueue.add(firstElement.right);
            }
        }
    }

    private Node deleteNode(Node current, int key) {
        if (current == null) {
            return current;
        }

        if (key < current.key) {
            current.left = deleteNode(current.left, key);
        } else if (key > current.key) {
            current.right = deleteNode(current.right, key);
        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            Node temp = minValueNode(current.right);
            current.key = temp.key;
            current.right = deleteNode(current.right, temp.key);
        }
        return current;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(5);
        bst.insert(3);

        bst.printBFS();
        bst.printInorder();
        bst.printPreorder();
        bst.printPostorder();

        bst.delete(6);
        System.out.println("After deletion of 6:");
        bst.printPreorder();
    }
}
