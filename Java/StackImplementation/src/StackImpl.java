public class StackImpl {

    // implement stack using array with fixed length
    private int[] arr;
    private int top;
    private int capacity;

    public StackImpl(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop() {

        if (isEmpty()) {
            System.out.println("Stack Empty");
            return 0;
        }

        return arr[top--];
    }

    public int getSize() {
        return top + 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl(6);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.print("Stack: ");
        stack.printStack();

        stack.pop();
        System.out.println("\nAfter popping out");
        stack.printStack();

        stack.push(6);
        stack.push(7);
        stack.push(6);
        stack.push(7);

        stack.printStack();

        stack.push(2);
    }

}
