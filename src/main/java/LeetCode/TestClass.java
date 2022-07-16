package LeetCode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Chris Yang
 * created 2022-05-31 11:01
 **/
public class TestClass {

    public ListNode reverseList(ListNode head) {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // n == sz
        if (fast == null) {
            return head.next;
        } else {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null && next != null) {
            if (cur.val == next.val) {
                while (next != null) {
                    if (cur.val != next.val) {
                        break;
                    }
                    next = next.next;
                }
                cur = next;
                if (cur != null) {
                    next = cur.next;
                }
            } else {
                pre.next = cur;
                pre = cur;
                cur = next;
                next = cur.next;
            }
        }

        pre.next = cur;

        return dummyHead.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        return dummyHead;
    }

    public static BufferedWriter getNIOTextWriter(String outfileS) {
        BufferedWriter bw = null;
        try {
            bw = Files.newBufferedWriter(Paths.get(outfileS), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bw;
    }

    public static BufferedReader getTextReader(String infileS) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(infileS), 65536);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return br;
    }

    public void test(){
        int i = 7;
        do{
            System.out.println(--i);
            --i;
        }while (i != 0);
        System.out.println(i);
    }



    public static void main(String[] args) throws IOException {
        ListNode A1 = new ListNode(1);
        ListNode A2 = new ListNode(2);
        ListNode A3 = new ListNode(3);
        ListNode A4 = new ListNode(3);
        ListNode A5 = new ListNode(4);
        ListNode A6 = new ListNode(4);
        ListNode A7 = new ListNode(5);

        A1.next = A2;
        A2.next = A3;
        A3.next = A4;
        A4.next = A5;
        A5.next = A6;
//        A6.next = A7;

        ListNode res = new TestClass().deleteDuplicates(A1);

        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }

        System.out.println("null");

        new TestClass().test();
    }
}
