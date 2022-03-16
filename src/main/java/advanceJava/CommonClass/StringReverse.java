package advanceJava.CommonClass;

/**
 * @author Chris Yang
 * created 2022-03-16 14:30
 **/
public class StringReverse {
    public static void main(String[] args) {
        String s = "abcde";
        String s1 = StringReverse(s, 2, 4);
        System.out.println(s1);
    }

    public static String StringReverse(String string, int start, int end) {
        char[] chars = string.toCharArray();
        char c = ' ';
        while (start < end) {
            c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
}
