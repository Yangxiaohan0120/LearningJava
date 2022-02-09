package PTA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ author: yxh
 * @ created: 2022-01-10 : 2:24 PM
 */
public class ThreeNplusOneplus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[] arr = new int[3000];
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            int n = scan.nextInt();
            nums[i] = n;
            while (n != 1) {
                if (n % 2 == 1) {
                    n = (3 * n + 1) / 2;
                } else {
                    n = n / 2;
                }
                arr[n] = 1;
            }
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (arr[nums[i]] == 0 && count == 0) {
                System.out.print(nums[i]);
                count++;
            }else if (arr[nums[i]] == 0) {
                System.out.print(" "+nums[i]);
            }
        }
    }
}