package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris Yang
 * created 2022-07-14 21:09
 **/

//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//
//数值（按顺序）可以分成以下几个部分：
//
//若干空格
//一个 小数 或者 整数
//（可选）一个 'e' 或 'E' ，后面跟着一个 整数
//若干空格
//小数（按顺序）可以分成以下几个部分：
//
//（可选）一个符号字符（'+' 或 '-'）
//下述格式之一：
//至少一位数字，后面跟着一个点 '.'
//至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
//一个点 '.' ，后面跟着至少一位数字
//整数（按顺序）可以分成以下几个部分：
//
//（可选）一个符号字符（'+' 或 '-'）
//至少一位数字
//部分数值列举如下：
//
//["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
//部分非数值列举如下：
//
//["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
//


public class StringRepresentNumber {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character,Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<Character,Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<Character,Integer>() {{ put('d', 3); }},                                        // 4.
                new HashMap<Character,Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<Character,Integer>() {{ put('d', 7); }},                                        // 6.
                new HashMap<Character,Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<Character,Integer>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

    public static void main(String[] args) {
        String[] correct = {"+100", "5e2", "-123", "3.1416", "-1E-16", "0123"};
        String[] wrong = {"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};

        StringRepresentNumber srn = new StringRepresentNumber();

        System.out.println("=============Correct==============");
        for (int i = 0; i < correct.length; i++) {
            System.out.println(srn.isNumber(correct[i]));
        }

        System.out.println("=============Wrong=================");
        for (int i = 0; i < wrong.length; i++) {
            System.out.println(srn.isNumber(wrong[i]));
        }
    }

}
