package DataStructureAndAlgorithm.Linear.queue;

import java.util.Stack;

/**
 * implements Queue with Stack
 *
 * @ author: yxh
 * @ created: 2021-12-20 : 11:36 AM
 */
public class MyQueue1 {

    private Stack<Integer> stack;
    int front;

    public MyQueue1() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (empty()) {
            front = x;
        }
        stack.push(x);
    }

    public int pop() {
        Stack<Integer> stack2 = new Stack<>();

        while ((stack.size() > 1)) {
            front = stack.peek();
            stack2.push(stack.pop());
        }

        int ret = stack.pop();

        while (!stack2.isEmpty())
            stack.push(stack2.pop());

        return ret;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < stack.size(); i++) {
            res.append(stack.get(i));
            if (i != stack.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}