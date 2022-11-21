package 剑指Offer;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-08-04 20:22
 **/
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.pop();
    }

    public void push_back(int value) {
        queue.add(value);
        while(!deque.isEmpty() && deque.peekLast() <value){
            deque.pollLast();
        }
        deque.add(value);
    }

    public int pop_front() {
        if(queue.isEmpty())return -1;
        if(queue.peek().equals(deque.peekFirst())){
            deque.pollFirst();
        }
        return queue.poll();
    }
}
