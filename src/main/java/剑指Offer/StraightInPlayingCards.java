package 剑指Offer;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-08-04 21:08
 **/
public class StraightInPlayingCards {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < 4; i++) {
            if(nums[i] == 0)joker ++;
            else if(nums[i] == nums[i+1])return false;
        }

        return nums[4] - nums[joker] < 5;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,2,5};
        System.out.println(new StraightInPlayingCards().isStraight(nums));
    }
}
