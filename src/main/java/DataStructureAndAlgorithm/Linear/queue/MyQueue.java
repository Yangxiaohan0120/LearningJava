package DataStructureAndAlgorithm.Linear.queue;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 *
 * @ author: yxh
 * @ created: 2021-12-20 : 11:28 AM
 */
class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        Stack<Integer> stack2 = new Stack<>();

        while (!stack.empty())
            stack2.push(stack.pop());

        stack2.push(x);

        while (!stack2.isEmpty())
            stack.push(stack2.pop());
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
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
            if (i != stack.size() - 1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
