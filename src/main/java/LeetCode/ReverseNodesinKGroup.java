package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 4:15 PM
 */
public class ReverseNodesinKGroup {

    public ListNode ReverseNodesinKGroup(ListNode head, int k) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;

        ListNode p = dummyhead;
        while (p.next != null && p.next.next != null) {
            ListNode[] node = new ListNode[k];
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;

            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }

        return dummyhead.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        List<ListNode> list = new ArrayList<>();
        int n = k;

        ListNode node = head;
        ListNode cur = null;

        list.add(node);

        while (node != null) {
            if (n == 0) {
                list.add(node);
                cur.next = null;
                n = k;
                continue;
            }
            cur = node;
            node = node.next;
            n--;
        }


        ListNode dummyHead = new ListNode(0);
        node = dummyHead;

        for (int i = 0; i < list.size(); i++) {
            if (n != 0 && i == (list.size() - 1)) {
                node.next = (list.get(i));
                continue;
            }
            node.next = reverList(list.get(i));
            node = endNode(node);
        }

        return dummyHead.next;
    }


    public ListNode endNode(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }


    public ListNode reverList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode A1 = new ListNode(1);
        ListNode A2 = new ListNode(2);
        ListNode A3 = new ListNode(3);
        ListNode A4 = new ListNode(4);
        ListNode A5 = new ListNode(5);
        ListNode A6 = new ListNode(6);

        A1.next = A2;
        A2.next = A3;
        A3.next = A4;
        A4.next = A5;
        A5.next = A6;

        ListNode node = A1;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");

        ListNode res = new ReverseNodesinKGroup().reverseKGroup(A1, 4);

        node = res;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }

}