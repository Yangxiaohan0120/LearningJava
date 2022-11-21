package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-04 19:15
 **/
public class DuplicatedNumber {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }
}
