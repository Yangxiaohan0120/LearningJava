package LeetCode;

import java.util.HashSet;

/**
 * @author Chris Yang
 * created 2022-05-31 20:12
 **/
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;

        while (node != null) {
            if (set.contains(node)) {
                return node;
            } else {
                set.add(node);
                node = node.next;
            }
        }

        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null) return null;
        ListNode slower = head, faster = head;

        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) break;
        }

        if (faster == null || faster.next == null) return null;
        slower = head;

        while (slower != faster) {
            slower = slower.next;
            faster = faster.next;
        }

        return slower;
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
        A6.next = A3;

        System.out.println(new LinkedListCycleII().detectCycle1(A1).val);
    }
}
