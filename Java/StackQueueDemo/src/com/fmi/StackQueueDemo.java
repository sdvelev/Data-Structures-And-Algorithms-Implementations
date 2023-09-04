package com.fmi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class StackQueueDemo {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Queue<Integer> queue = new ArrayDeque<>();

    public void addToStack(int element) {
        stack.add(element);
    }

    public void popFromStack() {
        stack.poll();
    }

    public int peekFromStack() {
        return stack.element();
    }

    public void addToQueue(int element) {
        queue.add(element);
    }

    public void popFromQueue() {
        queue.poll();
    }

    public int peekFromQueue() {
        return queue.element();
    }

    public static void main(String[] args) {
        StackQueueDemo demo = new StackQueueDemo();
        demo.addToStack(102);
        demo.addToStack(666);
        demo.addToStack(333);
        demo.popFromStack();

        demo.addToQueue(678);
        demo.addToQueue(6);
        demo.addToQueue(999);
        demo.popFromQueue();

        System.out.println(demo.peekFromStack());
        System.out.println(demo.peekFromQueue());
    }
}
