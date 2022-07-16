package LeetCode;

import java.util.HashSet;

/**
 * @author Chris Yang
 * created 2022-06-19 13:10
 **/
public class BestNumber {
    public String greatestLetter(String s) {
        boolean[] big = new boolean[26];
        boolean[] small = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                small[c - 'a'] = true;
            } else {
                big[c - 'A'] = true;
            }
        }

        String res = "";
        for (int i = 0; i < 26; i++) {
            if (big[i] && small[i]) {
                res = (char)('A'+ i) + "";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new BestNumber().greatestLetter("lEeTcOdE");
    }
}
