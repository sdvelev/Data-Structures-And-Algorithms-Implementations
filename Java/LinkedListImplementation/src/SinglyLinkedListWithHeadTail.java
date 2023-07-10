import java.util.Objects;

public class SinglyLinkedListWithHeadTail {

    static class Node {
        private int data;
        private Node next;

        public Node (int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }

    private Node head;
    private Node tail;

    public SinglyLinkedListWithHeadTail() {
        this.head = null;
        this.tail = null;
    }

    public static void pushBack(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail, int element) {
        Node toAdd = new Node(element);

        if (singlyLinkedListWithHeadTail.head == null && singlyLinkedListWithHeadTail.tail == null) {
            singlyLinkedListWithHeadTail.head = toAdd;
            singlyLinkedListWithHeadTail.tail = singlyLinkedListWithHeadTail.head;
            return;
        }

        singlyLinkedListWithHeadTail.tail.next = toAdd;
        singlyLinkedListWithHeadTail.tail = toAdd;
    }

    public static void pushFront(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail, int element) {
        Node toAdd = new Node(element);

        if (singlyLinkedListWithHeadTail.head == null && singlyLinkedListWithHeadTail.tail == null) {
            singlyLinkedListWithHeadTail.head = toAdd;
            singlyLinkedListWithHeadTail.tail = toAdd;
            return;
        }

        toAdd.next = singlyLinkedListWithHeadTail.head;
        singlyLinkedListWithHeadTail.head = toAdd;
    }

    public static void insert(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail, int position, int element) {

        if (singlyLinkedListWithHeadTail == null) {
            System.out.println("The provided list cannot be null");
            return;
        }

        if (position == 0) {
            pushFront(singlyLinkedListWithHeadTail, element);
            return;
        } else if (singlyLinkedListWithHeadTail.head == null) {
            System.out.println("The provided list is empty but the position is not 0");
            return;
        }

        Node currentNode = singlyLinkedListWithHeadTail.head;
        Node previousNode = null;

        for (int i = 0; i < position; i++) {
            if (currentNode != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            } else {
                System.out.println("Cannot insert at invalid position");
                return;
            }
        }

        Node toAdd = new Node(element);
        toAdd.next = currentNode;
        previousNode.next = toAdd;
        if (singlyLinkedListWithHeadTail.tail.equals(previousNode)) {
            singlyLinkedListWithHeadTail.tail = previousNode.next;
        }
    }

    public static void deleteFirst(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail) {
        if (singlyLinkedListWithHeadTail == null) {
            System.out.println("The provided list cannot be null");
            return;
        }

        if (singlyLinkedListWithHeadTail.head == null) {
            System.out.println("First element cannot be deleted as the provided list is empty");
            return;
        }

        Node currentHead = singlyLinkedListWithHeadTail.head;
        if (currentHead.equals(singlyLinkedListWithHeadTail.tail)) {
            singlyLinkedListWithHeadTail.tail = null;
        }
        currentHead = currentHead.next;
        singlyLinkedListWithHeadTail.head = currentHead;
    }

    public static void deleteLast(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail) {
        Node currentNode = singlyLinkedListWithHeadTail.head;
        Node previousNode = null;

        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        singlyLinkedListWithHeadTail.tail = previousNode;
        previousNode.next = null;
    }

    public static void delete(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail, int position) {

        if (singlyLinkedListWithHeadTail == null) {
            System.out.println("The provided list cannot be null");
            return;
        }

        if (position == 0) {
            deleteFirst(singlyLinkedListWithHeadTail);
            return;
        } else if (singlyLinkedListWithHeadTail.head == null) {
            System.out.println("The provided list is empty but the position is not 0");
            return;
        }

        Node currentNode = singlyLinkedListWithHeadTail.head;
        Node previousNode = null;

        for (int i = 0; i < position; i++) {
            if (currentNode.next != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            } else {
                System.out.println("Cannot delete at invalid position");
                return;
            }
        }
        previousNode.next = currentNode.next;
        if (singlyLinkedListWithHeadTail.tail.equals(currentNode)) {
            singlyLinkedListWithHeadTail.tail = previousNode;
        }
    }

    public static void print(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail) {
        Node headCopy = singlyLinkedListWithHeadTail.head;
        while (headCopy != null) {
            System.out.println(headCopy.data + " ");
            headCopy = headCopy.next;
        }
    }

    public static void printReverse(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail, Node head) {
        if (head == null) {
            return;
        }

        printReverse(singlyLinkedListWithHeadTail, head.next);
        System.out.println(head.data);
    }

    public static boolean searchElement(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail, int x) {
        Node iter = singlyLinkedListWithHeadTail.head;
        while (iter != null) {
            if (iter.data == x) {
                return true;
            }
            iter = iter.next;
        }
       return false;
    }

    public static void reverse(SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail) {
        Node currentNode = singlyLinkedListWithHeadTail.head;
        Node previousNode = null;
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        singlyLinkedListWithHeadTail.head = previousNode;
    }

    public static void main(String[] args) {
        SinglyLinkedListWithHeadTail singlyLinkedListWithHeadTail = new SinglyLinkedListWithHeadTail();

        pushBack(singlyLinkedListWithHeadTail, 6);
        pushBack(singlyLinkedListWithHeadTail, 6);
        pushBack(singlyLinkedListWithHeadTail, 9);
        pushBack(singlyLinkedListWithHeadTail, 7);
        pushBack(singlyLinkedListWithHeadTail, 8);

        pushFront(singlyLinkedListWithHeadTail, 21);

        insert(singlyLinkedListWithHeadTail, 3, 11);

        print(singlyLinkedListWithHeadTail);

        insert(singlyLinkedListWithHeadTail, 30, 11);

        deleteFirst(singlyLinkedListWithHeadTail);

        deleteFirst(singlyLinkedListWithHeadTail);

        print(singlyLinkedListWithHeadTail);

        deleteLast(singlyLinkedListWithHeadTail);

        print(singlyLinkedListWithHeadTail);

        delete(singlyLinkedListWithHeadTail, 4);

        print(singlyLinkedListWithHeadTail);

        delete(singlyLinkedListWithHeadTail, 2);

        print(singlyLinkedListWithHeadTail);

        System.out.println(searchElement(singlyLinkedListWithHeadTail, 7));

        System.out.println("Print reverse:");

        printReverse(singlyLinkedListWithHeadTail, singlyLinkedListWithHeadTail.head);

        reverse(singlyLinkedListWithHeadTail);

        print(singlyLinkedListWithHeadTail);

        deleteLast(singlyLinkedListWithHeadTail);

        print(singlyLinkedListWithHeadTail);
    }
}
