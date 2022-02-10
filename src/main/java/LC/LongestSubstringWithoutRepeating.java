package LC;

/**
 * @ author: yxh
 * @ created: 2022-02-09 : 3:46 PM
 */
public class LongestSubstringWithoutRepeating {

    // Sliding window
    public int LongestSubstringWithoutRepeating(String s) {

        int l = 0,r = -1;
        int[] freq = new int[256];
        int res = 0;

        while(l < s.length()){

            if(r + 1 < s.length() && freq[s.charAt(r+1) - 'a'] == 0){
                freq[s.charAt(++r)] ++;
            }else {
                freq[s.charAt(l++)] --;
            }

            res = Math.max(res,r-l+1);

        }

        return res;
    }

}