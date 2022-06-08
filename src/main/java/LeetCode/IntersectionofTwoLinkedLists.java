package LeetCode;

/**
 * @author Chris Yang
 * created 2022-05-31 11:03
 **/

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while(nodeA != null && nodeB != null){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        int len = 0;
        int last = -1;
        if(nodeA == null){
            while(nodeB != null){
                len ++;
                nodeB = nodeB.next;
                last = 1;
            }
        }else {
            while(nodeA != null){
                len ++;
                nodeA = nodeA.next;
                last = 0;
            }
        }

        nodeA = headA;
        nodeB = headB;

        if(last == 1){
            while(len > 0){
                nodeB = nodeB.next;
                len --;
            }
        }else if(last == 0){
            while(len > 0){
                nodeA = nodeA.next;
                len --;
            }
        }

        while(nodeA != null && nodeB != null){
            if(nodeA == nodeB){
                return nodeA;
            }else {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }

        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while(nodeA != null && nodeB != null){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        if(nodeA == null){
            nodeA = headB;
        }else {
            nodeB = headA;
        }

        while(nodeA != null && nodeB != null){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        if(nodeA == null){
            nodeA = headB;
        }else {
            nodeB = headA;
        }

        while(nodeA != null && nodeB != null){
            if(nodeA == nodeB){
                return nodeA;
            }else {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a_pointer= headA;
        ListNode b_pointer= headB;
        if(headA==null || headB==null){
            return null;//no intersection
        }
        while(a_pointer!=b_pointer){
            if(a_pointer==null){
                a_pointer=headB;
            }else{
                a_pointer=a_pointer.next;
            }
            if(b_pointer==null){
                b_pointer=headA;
            }else{
                b_pointer=b_pointer.next;
            }
        }
        return b_pointer;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);

        ListNode curA1 = headA;
        ListNode curA2 = new ListNode(1);

        ListNode curB1 = headB;
        ListNode curB2 = new ListNode(6);
        ListNode curB3 = new ListNode(1);

        ListNode cur1 = new ListNode(8);
        ListNode cur2 = new ListNode(4);
        ListNode cur3 = new ListNode(5);

        curA1.next = curA2;
        curA2.next = cur1;
        cur1.next = cur2;
        cur2.next = cur3;

        curB1.next = curB2;
        curB2.next = curB3;
        curB3.next = cur1;

        System.out.println(new IntersectionofTwoLinkedLists().getIntersectionNode(headA,headB).val);
        System.out.println(new IntersectionofTwoLinkedLists().getIntersectionNode2(headA,headB).val);
        System.out.println(new IntersectionofTwoLinkedLists().getIntersectionNode3(headA,headB).val);

    }
}
