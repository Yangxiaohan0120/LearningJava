package 剑指Offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Chris Yang
 * created 2022-08-01 11:56
 **/
public class NoDuplicateString {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = -1;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }

            map.put(s.charAt(j), j);
            max = Math.max(max, j - i);
        }
        return max;
    }
}
