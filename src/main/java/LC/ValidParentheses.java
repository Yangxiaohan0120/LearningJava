package LC;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ author: yxh
 * @ created: 2022-02-11 : 6:21 PM
 */
public class ValidParentheses {

    // 判断括号是否合法
    public boolean ValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                st.push(s.charAt(i));
            }else if(st.isEmpty() || map.get(st.pop()) != s.charAt(i)){
                return false;
            }
        }

        return st.isEmpty();

    }

}