package LeetCodeII;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 3:14 PM
 */
public class LetterCombinationsofaPhoneNumber {

    private String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = null;

    // 给出一个数字字符串，返回键盘上所有有可能的字母字符串组合
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.equals(""))return res;
        findCombinations(digits,0,"");
        return res;
    }

    private void findCombinations(String digits,int index,String p){
        if(digits.length() == index){
            res.add(p);
            return;
        }

        char[] c = letterMap[digits.charAt(index) - '0'].toCharArray();

        for (int i = 0; i < c.length; i++) {
            findCombinations(digits,index+1,p+c[i]);
        }

        return;
    }

    public static void main(String[] args) {
        String digits = "134";
        LetterCombinationsofaPhoneNumber lc = new LetterCombinationsofaPhoneNumber();
        List<String> res = lc.letterCombinations(digits);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }

}