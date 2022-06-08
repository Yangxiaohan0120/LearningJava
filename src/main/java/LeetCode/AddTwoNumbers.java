package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 3:38 PM
 */
public class AddTwoNumbers {

    // 两个非空链表，表示两个非负整数，每一个整数的各位数字以顺序存储，返回这两个整数和的链表表示
    // 2 -> 4 -> 3
    // 5 -> 6 -> 4
    // 7 -> 0 -> 8

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode res = new ListNode(0);
        ListNode node = res;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? l1.val : 0;
            int y = l2 == null ? l2.val : 0;
            int sum = x + y + c;
            node.next = new ListNode(sum % 10);
            c = sum / 10;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            node = node.next;
        }

        if (c != 0) {
            node.next = new ListNode(c);
        }

        return res.next;
    }

}