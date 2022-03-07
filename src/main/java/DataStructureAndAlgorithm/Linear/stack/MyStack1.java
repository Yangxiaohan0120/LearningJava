package DataStructureAndAlgorithm.Linear.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * implements stack using queue
 *
 * @ author: yxh
 * @ created: 2021-12-20 : 12:11 PM
 */
public class MyStack1 {

    private Queue<Integer> q;
    private int top;

    public MyStack1() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        top = x;
    }

    public int pop() {
        Queue<Integer> q2 = new LinkedList<>();

        while(q.size()>1)
            //记录了top;
            top = q.peek();
            q2.add(q.remove());

        int ret = q.remove();
        q = q2;
        return ret;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }

}