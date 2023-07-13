import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        //Comparator<Task> comparator = Comparator.comparingInt(Task::priority);
        //Queue<Task> queue = new PriorityQueue<>(comparator);
        //Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        for (int i = 0; i < 8; i++) {
            int element = ThreadLocalRandom.current().nextInt(100);
            priorityQueue.offer(element);
            System.out.printf("priorityQueue.offer(%2d)-->queue = %s%n", element, priorityQueue);
        }

        while (!priorityQueue.isEmpty()) {
            Integer element = priorityQueue.poll();
            System.out.printf("priorityQueue.poll(%2d)-->queue = %s%n", element, priorityQueue);        }
    }
}
