import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode node = null;
        ListNode curnode = node;
        int c = 0;
        while (node1 != null || node2 != null) {
            int n1 = node1 == null ? 0 : node1.val;
            int n2 = node2 == null ? 0 : node2.val;
            int sum = n1 + n2 + c;
            if (node == null) {
                node = curnode = new ListNode(sum % 10);
            } else {
                curnode.next = new ListNode(sum / 10);
                curnode = curnode.next;
            }
        }

        if (c > 0) {
            curnode.next = new ListNode(c);
        }

        return node;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode pre = node;
        ListNode cur = node;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }

        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }

        pre.next = pre.next.next;

        return node;
    }

    //    public ListNode mergeKLists(ListNode[] lists) {
//
//    }
    public static ListNode mergeTwoLists1(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }


    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode a1 = a;
        ListNode b1 = b;

        while (a1 != null && b1 != null) {
            if (a1.val < b1.val) {
                tail.next = new ListNode(a1.val);
                a1 = a1.next;
            } else {
                tail.next = new ListNode(b1.val);
                b1 = b1.next;
            }
            tail = tail.next;
        }

        //使用a1 和 b1 用来直接加上剩余的部分，而不需要一个个的遍历。
        tail.next = (a1 != null ? a1 : b1);
        return head.next;
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            // 当两个值相等时存储值为x
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                //一直遍历到不等于重复值
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                //去除重复值取下一个（一直对cur.next进行判断）
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;
        inorderTraversal(root, res);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode node, List<Integer> list) {

        if (node.left != null) inorderTraversal(node.left, list);
        list.add(node.val);
        if (node.right != null) inorderTraversal(node.right, list);

        return list;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode leftNode = pre.next;
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;

        return dummyHead.next;
    }

    public void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public ListNode reverse(ListNode head) {
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
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        l1.next = new ListNode(3);
        l2.next = new ListNode(5);
        l1.next.next = new ListNode(3);
        l2.next.next = new ListNode(6);
//        ListNode head = addTwoNumbers(l1, l2);
        ListNode head = deleteDuplicates(l1);
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}