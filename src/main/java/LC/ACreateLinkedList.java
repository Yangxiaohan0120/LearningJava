package LC;

import java.util.LinkedList;
import java.util.List;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 2:32 PM
 */


public class ACreateLinkedList {

    public ListNode ACreateLinkedList(int[] arr,int n) {
        if(n == 0)
            return null;

        ListNode head = new ListNode(arr[0]);

        ListNode curNode = head;
        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }

        return head;
    }

    public void printLinkedList(ListNode head){

        ListNode curNode = head;
        while(curNode != null){
            System.out.print(curNode.val + " -> ");
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5};
        int n = arr.length;

        ACreateLinkedList ac = new ACreateLinkedList();
        ListNode head = ac.ACreateLinkedList(arr,n);
        ac.printLinkedList(head);

        ListNode tail = new RemoveNthNodeFromEndofList().RemoveNthNodeFromEndofList(head,2);
        ac.printLinkedList(tail);

    }

}