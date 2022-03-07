package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 9:12 AM
 */
public class LetterCombinationsofaPhoneNumber {

    private String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = null;

    // 给出一个数字字符串，返回键盘上所有有可能的字母字符串组合
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.equals("")) return res;
        findCombinations(digits, 0, "");
        return res;
    }

    private void findCombinations(String digits, int index, String s) {

//        System.out.println(index + ": " + s);

        if (index == digits.length()) {
            // 到达digits的末尾，将s保存到array结果中。
//            System.out.println(s);
            res.add(s);
            System.out.println("get "+s+" , return");
            return;
        }

        char c = digits.charAt(index);// 当前位置的char
        String letters = letterMap[c - '0']; // 对应index的letters

        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits["+index+"] : using "+letters.charAt(i));
            findCombinations(digits, index + 1, s + letters.charAt(i));
        }

        return;
    }

    public static void main(String[] args) {
        String digits = "134";
        List<String> res = new LetterCombinationsofaPhoneNumber().letterCombinations(digits);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}