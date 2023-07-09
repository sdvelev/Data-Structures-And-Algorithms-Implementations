public class LinkedListImplementation {

    private Node head;

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static LinkedListImplementation insert(LinkedListImplementation linkedListImplementation, int data) {
        Node newNode = new Node(data);

        if (linkedListImplementation.head == null) {
            linkedListImplementation.head = newNode;
        } else {
            Node lastNode = linkedListImplementation.head;
            while(lastNode.next != null) {
                lastNode = lastNode.next;
            }

            lastNode.next = newNode;
        }

        return linkedListImplementation;
    }

    public static void printList(LinkedListImplementation linkedListImplementation) {

        Node headCopy = linkedListImplementation.head;

        while(headCopy != null) {
            System.out.println(headCopy.data + " ");
            headCopy = headCopy.next;
        }
    }

    public static LinkedListImplementation delete(LinkedListImplementation linkedListImplementation, int key) {
        Node currentNode = linkedListImplementation.head;
        Node previousNode = null;

        if (currentNode != null && currentNode.data == key) {
            linkedListImplementation.head = currentNode.next;
            return linkedListImplementation;
        }

        while (currentNode != null && currentNode.data != key) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            previousNode.next = currentNode.next;
        }

        return linkedListImplementation;
    }

    public static LinkedListImplementation deleteAtPosition(LinkedListImplementation linkedListImplementation, int index){

        Node currentNode = linkedListImplementation.head;
        Node previousNode = null;

        if (index == 0 && currentNode != null) {
            linkedListImplementation.head = currentNode.next;

            return linkedListImplementation;
        }

        int counter = 0;
        while (currentNode != null) {
            if (counter == index) {
                previousNode.next = currentNode.next;
                break;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
                ++counter;
            }
        }

        if (currentNode == null) {
            throw new IndexOutOfBoundsException("There is not such an element position in the list");
        }
        return linkedListImplementation;
    }

    public static void main(String[] args) {
        LinkedListImplementation linkedListImplementation = new LinkedListImplementation();
        insert(linkedListImplementation, 1);
        insert(linkedListImplementation, 2);
        insert(linkedListImplementation, 3);
        insert(linkedListImplementation, 4);
        insert(linkedListImplementation, 5);
        insert(linkedListImplementation, 6);
        insert(linkedListImplementation, 6);
        System.out.println("Print list:");
        printList(linkedListImplementation);
        System.out.println("After delete of element 4:");
        printList(delete(linkedListImplementation, 4));
        System.out.println("After delete at position 2:");
        printList(deleteAtPosition(linkedListImplementation, 2));
    }
}
