package 剑指Offer;


import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-07-23 16:51
 **/
public class CQueue {
    Stack<Integer> A;
    Stack<Integer> B;

    public CQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void appendTail(int value) {
        A.push(value);
    }

    public int deleteHead() {
        while (!A.isEmpty()) {
            B.push(A.pop());
        }
        int res = B.isEmpty() ? -1 : B.pop();
        while (!B.isEmpty()) {
            A.push(B.pop());
        }
        return res;
    }
}
