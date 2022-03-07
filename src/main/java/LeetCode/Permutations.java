package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-14 : 9:48 AM
 */
public class Permutations {

    private List<List<Integer>> res;
    private boolean[] used;

    // 排列问题
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0 )return res;
        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutations(nums,0,p,used);
        return res;
    }

    private void generatePermutations(int[] nums, int index ,LinkedList<Integer> p,boolean[] used){
        if(p.size() == nums.length){
            res.add(new ArrayList<>(p));
            //  Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。这些地址被添加到 res 变量，
            //  但实际上指向的是同一块内存地址，因此我们会看到 6 个空的列表对象。解决的方法很简单，在 res.add(path); 这里做一次拷贝即可

            System.out.print("get ");
            for (int i = 0; i < p.size(); i++) {
                System.out.print(p.get(i) + "->");
            }
            System.out.println("null , return");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
//                System.out.println("nums["+index+"] : using "+nums[i]);
                p.add(nums[i]);
                used[i] = true;
                generatePermutations(nums,index+1,p,used);
                used[i] = false;
                p.remove(p.size()-1);

            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new Permutations().permute(nums);
        for (int i = 0; i < res.size(); i++) {
//            System.out.println(p.size());
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).size());
                System.out.print(res.get(i).get(j) + "->");
            }
//            System.out.println("null , return");
        }
    }

}