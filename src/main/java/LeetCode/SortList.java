package LeetCode;

import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 4:20 PM
 */
public class SortList {

    // 4 -> 2 -> 1 -> 3
    // 1 -> 2 -> 3 -> 4

    // 使用 O(nlogn) 的时间复杂度为链表排序，使用归并排序！！！
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = midListNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode res = mergeSort(left, right);
        return res;
    }

    public ListNode midListNode(ListNode head) {
        if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode res = slow.next;
        slow.next = null;

        return res;
    }

    public ListNode mergeSort(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 != null) {
            node.next = l1;
        }

        if (l2 != null) {
            node.next = l2;
        }

        while (node != null) {
            node = node.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode A1 = new ListNode(-1);
        ListNode A2 = new ListNode(5);
        ListNode A3 = new ListNode(3);
        ListNode A4 = new ListNode(4);
        ListNode A5 = new ListNode(0);
//        ListNode A6 = new ListNode(2);

        A1.next = A2;
        A2.next = A3;
        A3.next = A4;
        A4.next = A5;
//        A5.next = A6;

        ListNode node = A1;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");

        ListNode res = new SortList().sortList(A1);

        node = res;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }

}