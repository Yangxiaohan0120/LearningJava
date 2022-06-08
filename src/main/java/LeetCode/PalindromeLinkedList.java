package LeetCode;

import java.util.LinkedList;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 4:52 PM
 */
public class PalindromeLinkedList {

    // 判断是否是回文链表
    public boolean isPalindrome(ListNode head) {
        LinkedList values = new LinkedList<>();

        ListNode node = head;
        while (node != null) {
            values.add(node.val);
            node = node.next;
        }

        int front = 0;
        int back = values.size() - 1;
        while(front < back){
            if(values.get(front) != values.get(back)){
                return false;
            }
            front ++;
            back --;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(new PalindromeLinkedList().isPalindrome(node1));
    }
}