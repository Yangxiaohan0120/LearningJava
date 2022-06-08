package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 4:50 PM
 */
public class ReorderList {

    // 递归写法
    public void reorderList(ListNode head) {
        // || head.next.next == null
        if(head == null || head.next == null){
            return;
        }

        ListNode node = head;
        while(node != null && node.next != null){
            node.next = update(node.next);
            node = node.next.next;
        }

    }

    public ListNode update(ListNode head){
        if(head == null || head.next == null)return head;

        ListNode node = head;
        while(node.next.next != null){
            node = node.next;
        }

        ListNode newHead = node.next;
        node.next = null;
        newHead.next = head;

        return newHead;
    }

    // 直接排序
    // 找中点
    public static ListNode mid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 中点之后的节点进行逆序，这样就相当于栈了
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode frwd = null;

        while(curr != null){
            frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }

        return prev;

    }

    // 重新按需连接
    public void reorderList1(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode mid_ = mid(head);
        ListNode nhead = mid_.next;
        mid_.next = null;

        nhead = reverse(nhead);

        // 两段的开头，分别代表着链表正序和逆序，各一半的链
        ListNode c1 = head;
        ListNode c2 = nhead;
        ListNode f1 = null;
        ListNode f2 = null;

        // 头节点+尾节点+下一组
        while(c2 != null){
            f1 = c1.next;
            f2 = c2.next;

            // 头节点连尾节点
            c1.next = c2;
            // 连接下一组
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }


    public static void main(String[] args) {
        ListNode A1 = new ListNode(1);
        ListNode A2 = new ListNode(2);
//        ListNode A3 = new ListNode(3);
//        ListNode A4 = new ListNode(4);
//        ListNode A5 = new ListNode(5);
//        ListNode A6 = new ListNode(6);

        A1.next = A2;
//        A2.next = A3;
//        A3.next = A4;
//        A4.next = A5;
//        A5.next = A6;

        ListNode node = A1;
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");

        new ReorderList().reorderList(A1);

        node = A1;
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }

}