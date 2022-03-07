package DataStructureAndAlgorithm.Linear.queue;

import java.util.Stack;

/**
 * implements queue with stack
 *
 * @ author: yxh
 * @ created: 2021-12-20 : 11:50 AM
 */
public class MyQueue2 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    int front;

    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty())
            front = x;
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty())
            return stack2.pop();
        while(stack1.size()>1)
            stack2.push(stack1.pop());
        return stack1.pop();
    }

    public int peek() {
        if (!stack2.empty())
            return stack2.peek();
        return front;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < stack1.size(); i++) {
            res.append(stack1.get(i));
            if (i != stack2.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail    ");
        res.append("front [");
        for (int i = 0; i < stack2.size(); i++) {
            res.append(stack2.get(i));
            if (i != stack2.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}