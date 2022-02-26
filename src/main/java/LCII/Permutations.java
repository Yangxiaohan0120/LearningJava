package LCII;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-17 : 12:44 PM
 */
public class Permutations {

    List<List<Integer>> res;
    boolean[] visited;

    // 排列问题
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        getPermute(nums,0,p);
        return res;
    }

    private void getPermute(int[] nums, int index , List<Integer> p){
        if(index == nums.length){
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i] == false){
                p.add(nums[i]);
                visited[i] = true;
                getPermute(nums,index+1,p);
                p.remove(p.size()-1);
                visited[i] = false;
            }
        }
    }

}