package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-23 16:29
 **/
public class ReplaceStringinSentence {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
