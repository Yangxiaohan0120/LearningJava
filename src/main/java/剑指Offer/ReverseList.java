package 剑指Offer;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-07-23 16:32
 **/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReverseList {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode node = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (node != null) {
            map.put(count, node.val);
            count++;
            node = node.next;
        }

        int sum = count;
        int[] res = new int[count];
        while (count > 0) {
            count--;
            res[sum - count - 1] = map.get(count);
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        ListNode node = reverse(head);
        List<Integer> list = new LinkedList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);


        int[] res = new ReverseList().reversePrint(head);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

        int[] res1 = new ReverseList().reversePrint2(head);
        for (int i = 0; i < res1.length; i++) {
            System.out.println(res1[i]);
        }
    }
}
