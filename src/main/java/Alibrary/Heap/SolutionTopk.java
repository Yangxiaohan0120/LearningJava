/// 剑指 Offer 40
/// https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/submissions/

import Alibrary.Heap.PriorityQueue;

class SolutionTopk {

    public int[] getLeastNumbers(int[] arr, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i ++)
            pq.enqueue(arr[i]);

        //如果arr[i] 小于maxheap的最大值，则入列
        for(int i = k; i < arr.length; i ++)
            if(!pq.isEmpty() && arr[i] < pq.getFront()){
                pq.dequeue();
                pq.enqueue(arr[i]);
            }

        int[] res = new int[k];
        for(int i = 0; i < k; i ++)
            res[i] = pq.dequeue();
        return res;
    }


}
