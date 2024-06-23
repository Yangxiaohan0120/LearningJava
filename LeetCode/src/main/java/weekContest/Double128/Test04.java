package weekContest.Double128;

import java.util.HashMap;
import java.util.Map;

public class Test04 {

    public String findLatestTime(String s) {
        char[] c = s.toCharArray();
        if (c[1] == '?') {
            if (c[0] == '?' || c[0] == '1') {
                c[0] = '1';
                c[1] = '1';
            } else {
                c[1] = '9';
            }
        }
        if(c[0] == '?'){
            if(c[1] > '1'){
                c[0] = '0';
            }
        }
        if (c[4] == '?') {
            c[4] = '9';
        }
        if (c[3] == '?') {
            c[3] = '5';
        }
        return String.valueOf(c);
    }

    public long numberOfSubarrays(int[] nums) {
        HashMap<Integer, Long> timesMap = new HashMap<>();
        HashMap<Integer, Long> totalMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (Map.Entry<Integer, Long> entry : timesMap.entrySet()) {
                if (entry.getKey() < nums[i]) {
                    timesMap.put(entry.getKey(), 0L);
                }
            }
            if (totalMap.get(nums[i]) == null) {
                totalMap.put(nums[i], 1L);
            } else {
                totalMap.put(nums[i], totalMap.get(nums[i]) + timesMap.get(nums[i]) + 1);
            }
            if (timesMap.get(nums[i]) == null || timesMap.get(nums[i]) == 0) {
                timesMap.put(nums[i], 1L);
            } else {
                timesMap.put(nums[i], timesMap.get(nums[i]) + 1);
            }
        }
        long res = 0;
        for (Map.Entry<Integer, Long> entry : totalMap.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }

    public void test() {
//        int[] nums = {1,4,3,3,2};
//        int[] nums1 = {1,3,3,3,4,3};
//        int[] nums2 = {6,26,6,26};
//        System.out.println(numberOfSubarrays(nums1));
        System.out.println(findLatestTime("0?:??"));
    }

    public static void main(String[] args) {
        new Test04().test();
    }
}
