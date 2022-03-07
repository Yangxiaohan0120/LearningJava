package LeetCodeII;

import java.util.Stack;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 2:08 PM
 */
public class EvaluateReversePolishNotation {

    // 逆波兰表达式求值，给定一个数组，表示一个逆波兰表达式，求值；
    // ['2','1','+','3','*'] = (2+1)*3 = 9
    // ['4','13,'5','/'.'+'] = (4 + 13/5) = 6
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        int res = 1;
        for(String s : tokens){
            if(s.equals("+")){
                st.push(st.pop() + st.pop());
            }else if(s.equals("*")){
                st.push(st.pop() * st.pop());
            }else if(s.equals("-")){
                int first = st.pop();
                st.push(st.pop() - first);
            }else if(s.equals("/")){
                int first = st.pop();
                st.push(st.pop()/first);
            }else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }

}