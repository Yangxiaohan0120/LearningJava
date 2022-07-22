package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-22 15:12
 **/
public class SmallestNumberinRotatedArray {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            }else if(numbers[mid] == numbers[r]){
                r --;
            }
        }
        return numbers[l];
    }
}
