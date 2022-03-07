package DataStructureAndAlgorithm.Linear.list;

/**
 * @ author: yxh
 * @ description 使用dummyHead 减少对head的特殊处理
 * @ created: 2021-12-20 : 4:29 PM
 */
class ListNodeSolution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println((new ListNodeSolution2()).removeElements(head,6));
    }
}