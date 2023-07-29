package Collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare( o2.length(),o1.length());
    }
}
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> q = new PriorityQueue<>(new StringLengthComparator()) {};
        System.out.println(q);
        q.add("zApple");
        q.offer("Offer1");
        q.offer("zen");
        q.offer("Ambition");
        q.offer("Maruti");
        q.offer("Maruti");
        q.offer("Scorpio");
        //q.offer(null); //PriorityQueue doesn't allow null values to be stored in the queue.

        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
    }
}
