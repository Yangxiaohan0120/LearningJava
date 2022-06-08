package LeetCode;

/**
 * Important
 *
 * @ author: yxh
 * @ created: 2022-02-13 : 3:21 PM
 */
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)return null;
        return mergeList(0, lists.length-1,lists);
    }

    public ListNode mergeList(int i,int j,ListNode[] lists){
        if( i == j)return lists[i];
        int mid = i + (j-i)/2;
        ListNode left = mergeList(i,mid,lists);
        ListNode right = mergeList(mid+1,j,lists);
        return mergeTwoLists(left,right);
    }

    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;

        while (nodeA != null && nodeB != null) {
            if (nodeA.val <= nodeB.val) {
                node.next = nodeA;
                nodeA = nodeA.next;
            } else {
                node.next = nodeB;
                nodeB = nodeB.next;
            }

            node = node.next;
        }

        if (nodeA != null) {
            node.next = nodeA;
        }

        if (nodeB != null) {
            node.next = nodeB;
        }

        return dummyHead.next;

    }


    //Input: lists = [[1,4,5],[1,3,4],[2,6]]
    //Output: [1,1,2,3,4,4,5,6]
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(1);
        ListNode headC = new ListNode(2);

        ListNode curA1 = new ListNode(4);
        ListNode curA2 = new ListNode(5);
        ListNode curB1 = new ListNode(3);
        ListNode curB2 = new ListNode(4);
        ListNode curC1 = new ListNode(6);

        headA.next = curA1;
        curA1.next = curA2;

        headB.next = curB1;
        curB1.next = curB2;

        headC.next = curC1;

        ListNode[] lists = {headA, headB, headC};

        ListNode res = new MergekSortedLists().mergeKLists(lists);

        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }

        System.out.println("null");
    }

}