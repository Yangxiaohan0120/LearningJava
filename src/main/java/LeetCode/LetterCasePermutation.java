package LeetCode;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-04-10 12:56
 **/
public class LetterCasePermutation {
    private List<String> res;

    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        if (s.length() == 0) return res;
        LinkedList<Character> p = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        generateString(s, 0, s.length(), p);
        return res;
    }

    public void generateString(String s, int index, int length, LinkedList<Character> p) {
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < p.size(); i++) {
                sb.append(p.get(i));
            }
            res.add(sb.toString());
            return;
        }

        p.add(s.charAt(index));
        generateString(s, index + 1, s.length(), p);
        if (isLetter(s.charAt(index)) == 0) {
            p.remove(p.size() - 1);
            p.add(Character.toUpperCase(s.charAt(index)));
            generateString(s, index + 1, s.length(), p);
        } else if (isLetter(s.charAt(index)) == 1) {
            p.remove(p.size() - 1);
            p.add(Character.toLowerCase(s.charAt(index)));
            generateString(s, index + 1, s.length(), p);
        }
        p.remove(p.size() - 1);

    }

    private int isLetter(char c) {
        if (c >= 'a' && c <= 'z') return 0;
        if (c >= 'A' && c <= 'Z') return 1;
        else return -1;
    }

    public static void main(String[] args) {
        String s = "3z4";
        List<String> res = new LetterCasePermutation().letterCasePermutation(s);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
