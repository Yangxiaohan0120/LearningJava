package 剑指Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-08-01 10:38
 **/
public class translateNum {

    int count = 0;

    public int translateNum(int num) {
        String s = String.valueOf(num);
        dfs(s, 0);
        return count;
    }

    public void dfs(String s, int index) {
        if (index >= s.length() - 1) {
            count++;
            return;
        }

        dfs(s, index + 1);
        if ((s.charAt(index) == '2' && s.charAt(index + 1) <= '5') || s.charAt(index) == '1') {
            dfs(s, index + 2);
        }
    }

    public static void main(String[] args) {
        int nums = new translateNum().translateNum(11);
        System.out.println(nums);
    }
}
