package 剑指Offer;

import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-07-27 21:55
 **/
public class ValidationStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        for(int num : pushed){
            st.push(num);
            while(!st.isEmpty() && st.peek() == popped[i]){
                st.pop();
                i++;
            }
        }
        return st.isEmpty();
    }
}
