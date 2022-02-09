// Leetcode 215
// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/

import Alibrary.Heap.MinHeap;

import java.util.PriorityQueue;

class SolutionKlargest {

    public int findKthLargest(int[] nums, int k) {

        MinHeap<Integer> pq = new MinHeap<>();
        for(int i = 0; i < k; i ++)
            pq.add(nums[i]);

        for(int i = k; i < nums.length; i ++)
            if(!pq.isEmpty() && nums[i] > pq.findMin()){
                pq.replace(nums[i]);
            }

        return pq.findMin();
    }

    //使用java标准库
    public int findKthLargest1(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i ++)
            pq.add(nums[i]);

        for(int i = k; i < nums.length; i ++)
            if(!pq.isEmpty() && nums[i] > pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }

        return pq.peek();
    }
}
