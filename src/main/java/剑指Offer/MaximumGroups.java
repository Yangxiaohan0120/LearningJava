package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-02 12:52
 **/
public class MaximumGroups {
    public int MaximumGroups(int[] grades) {
        int n = grades.length, base = 1;
        while (n > 0) {
            n -= base;
            if(n >= 0) {
                base += 1;
            }
        }
        return base - 1;
    }

    public static void main(String[] args) {
        int[] nums = {8, 8,9,10};
        System.out.println(new MaximumGroups().MaximumGroups(nums));
    }

}
