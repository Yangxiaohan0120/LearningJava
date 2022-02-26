package LCII;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 3:42 PM
 */
public class LongestSubstringWithoutRepeating {

    // Sliding window
    public int LongestSubstringWithoutRepeating(String s) {
        int fast = -1;
        int slow = 0;
        int[] freq = new int[256];
        int res = 0;

        while(slow < s.length()){
            if(fast+1 < s.length() && freq[s.charAt(fast+1) - 'a'] == 0){// 原来不存在
                fast ++;
                freq[s.charAt(fast) - 'a'] ++; // 标记并向后移
            }else {
                freq[s.charAt(slow) - 'a']--; //
                slow ++;
            }

            res = Math.max(res,fast-slow+1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abda";
        System.out.println(new LongestSubstringWithoutRepeating().LongestSubstringWithoutRepeating(s));
    }
}