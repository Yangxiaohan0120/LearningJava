package LeetCode;

import java.util.List;

/**
 * @author Chris Yang
 * created 2022-04-14 22:31
 **/

// Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list. Return the linked list sorted as well.

// 1 2 3 3 4 4 5
// 1 2 5

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            if (head.val == head.next.val) {
                return new ListNode();
            } else {
                return head;
            }
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = head.next;
        boolean flag = false;
        while (temp != null) {

            // 如果相等
            if (cur.val == temp.val) {
                // 3号键向后移动一位
                cur.next = temp.next;
                temp = cur.next;

                // 如果已经移动到末尾，去除cur，pre直接链接null
                if (temp == null && prev != null)
                    prev.next = null;
                // 证明目前的cur是一个重复的单元
                flag = true;
            } else {
                // 如果不相等，但是cur还是重复的元素
                if (flag) {
                    //前面全都是重复元素，直接从temp开始，重新开始计算
                    if (prev == null) {
                        head = temp;
                        cur = temp;
                    } else {
                        // 如果prev不是空的，跳过cur
                        prev.next = cur.next;
                        cur = prev.next;
                    }
                    // cur已经跳过，所以flag设为false
                    flag = false;
                } else {
                    // 不等，且cur也不曾和别的相等，直接向后移动。
                    prev = cur;
                    cur = temp;
                }
                // temp也相应的移动，看是否能到末尾
                temp = temp.next;
            }
        }

        // 如果剩下的cur是重复的，并且之前的所有的也是重复的，直接返回null
        if (flag && prev == null)
            return null;
        else
            return head;
    }
}
