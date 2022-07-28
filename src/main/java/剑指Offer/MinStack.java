package 剑指Offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-07-27 20:50
 **/
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> smallest;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        smallest = new Stack<>();
        smallest.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        if(smallest.isEmpty() || smallest.peek() >= x){
            smallest.add(x);
        }
    }

    public void pop() {
        if(stack.peek().equals(smallest.peek())){
            smallest.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return smallest.peek();
    }
}
