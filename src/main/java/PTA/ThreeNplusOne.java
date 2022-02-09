package PTA;

/**
 * @ author: yxh
 * @ created: 2022-01-10 : 11:17 AM
 */
import java.util.Scanner;

public class ThreeNplusOne{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int nums = 0;
        while(n != 1){
            if(n % 2 == 1){
                n = (3*n+1)/2;
            }else{
                n = n/2;
            }
            nums ++;
        }
        System.out.println(nums);
    }
}