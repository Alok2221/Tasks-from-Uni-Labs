package third_semester.lab05.exe01;

import java.util.PriorityQueue;

public class ColoursQueue {
    public static void main(String[] args) {
        PriorityQueue<String> coloursQueue = new PriorityQueue<>();
        coloursQueue.offer("Red");
        coloursQueue.offer("Green");
        coloursQueue.offer("Orange");
        coloursQueue.offer("White");
        coloursQueue.offer("Black");

        coloursQueue.forEach(System.out::println);

        System.out.println("\n" + coloursQueue.peek());
        System.out.println(coloursQueue.poll());
    }
}