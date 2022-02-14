package LC;

import javafx.util.Pair;

import java.util.*;

/**
 * @ author: yxh
 * @ created: 2022-02-13 : 3:05 PM
 */
public class TopKFrequentElements {

    // 给定一个非空数组，返回前k个出现频率最高的元素
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(fmap.containsKey(nums[i])){
                fmap.put(nums[i],fmap.get(nums[i])+1);
            }else {
                fmap.put(nums[i],1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());

        for(Map.Entry<Integer,Integer> keySet : fmap.entrySet())
            pq.offer(keySet);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }

        return res;
    }

}