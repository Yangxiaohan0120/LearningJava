package LeetCode;

import DataStructureAndAlgorithm.map.Map;
import org.checkerframework.checker.units.qual.A;

/**
 * @author Chris Yang
 * created 2022-06-08 21:27
 **/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int Area = calArea(height,l,r);

        while(l < r){
            Area = Math.max(Area,calArea(height,l,r));
            if(height[l] > height[r]){
                r--;
            }else {
                l++;
            }
        }

        return Area;
    }

    public int calArea(int[] height,int l,int r){
        return Math.min(height[l], height[r]) * (r - l);
    }
}
