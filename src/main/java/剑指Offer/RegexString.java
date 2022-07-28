package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-25 10:29
 **/
public class RegexString {
    public boolean isMatch(String s, String p) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s.length() && index2 < p.length()) {
            if (p.charAt(index2) == '.') {
                index1++;
                index2++;
            } else if (p.charAt(index2) == '*') {
                if (index2 == 0) {
                    index2++;
                } else if (p.charAt(index2 - 1) == '.' || p.charAt(index2 - 1) == s.charAt(index1)) {
                    index1++;
                } else {
                    index2++;
                }
            } else {
                if (p.charAt(index2) == s.charAt(index1)) {
                    index1++;
                    index2++;
                } else if (p.charAt(index2 + 1) == '*') {
                    index2++;
                } else return false;
            }
        }

        if (index1 == s.length() && index2 == p.length()) return true;
        if (index1 < s.length() && index2 == p.length()) return false;
        while (index2 < p.length()) {
            if (p.charAt(index2) == '*') {
                if (s.charAt(index1 - 1) == p.charAt(index2 - 1)) {
                    index2++;
                } else return false;
            } else {
                if (s.charAt(index1 - 1) != p.charAt(index2)) {
                    if (p.charAt(index2 + 1) == '*') {
                        index2 += 2;
                    } else return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "aaa";
        String p = "ab*a*c*a";
        boolean res = new RegexString().isMatch(s, p);
        System.out.println(res);

    }
}
