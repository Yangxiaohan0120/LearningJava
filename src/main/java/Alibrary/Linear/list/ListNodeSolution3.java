package Alibrary.Linear.list;

/**
 * @ author: yxh
 * @ 使用递归思想进行删除元素
 * @ created: 2021-12-21 : 3:01 PM
 */
public class ListNodeSolution3 {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode res = removeElements(head.next,val);
//        if(head.val == val){
//            return res;
//        }else {
//            head.next = res;
//            return head;
//        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println((new ListNodeSolution3()).removeElements(head,6));
    }
}