package LeetCode;

/**
 * @author Chris Yang
 * created 2022-04-02 16:41
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int l = 0,r = -1;
        int[] freq = new int[256];
        int res = 0;

        // 左侧小于长度
        while(l < s.length()){

            // 还可以向右移并且移了之后不重复
            if(r + 1 < s.length() && freq[s.charAt(r+1)] == 0){
                freq[s.charAt(++r)] ++;
                res = Math.max(res,r-l+1);
                // 先移后记录
            }else {
                // 不可再移动或者移动后有重复元素
                // 去掉当前元素，并向友移
                freq[s.charAt(l++)] --;
                // 并不一定重复的元素在第一个，所以不能更新长度现在。
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
