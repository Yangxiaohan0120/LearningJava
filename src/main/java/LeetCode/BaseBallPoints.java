package LeetCode;

import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-03-28 16:30
 **/
public class BaseBallPoints {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")){
                stack.pop();
            }else if (ops[i].equals("D")){
                stack.add(stack.peek()*2);
            }else if (ops[i].equals("+")){
                int m1 = stack.pop();
                int m2 = stack.peek();
                stack.add(m1);
                stack.add(m1+m2);
            }else {
                stack.add(Integer.parseInt(ops[i]));
            }
        }

        int res = 0;
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        String[] var = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(var));
    }
}
