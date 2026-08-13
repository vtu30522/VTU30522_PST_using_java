import java.util.PriorityQueue;
import java.util.Collections;

public class PriorityQueueExample {
    public static void main(String[] args) {

        // Min Priority Queue
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        minPQ.add(30);
        minPQ.add(10);
        minPQ.add(20);
        minPQ.add(5);

        System.out.println("Min Priority Queue:");

        while (!minPQ.isEmpty()) {
            System.out.println(minPQ.poll());
        }


        // Max Priority Queue
        PriorityQueue<Integer> maxPQ =
                new PriorityQueue<>(Collections.reverseOrder());

        maxPQ.add(30);
        maxPQ.add(10);
        maxPQ.add(20);
        maxPQ.add(50);

        System.out.println("Max Priority Queue:");

        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.poll());
        }
    }
}