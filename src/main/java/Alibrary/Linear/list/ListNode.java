package Alibrary.Linear.list;

/**
 * @ author: yxh
 * @ created: 2021-12-20 : 4:21 PM
 */
public class ListNode {

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

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Argument is empty");

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = this;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    // 递归写法
    public ListNode reverse2(ListNode head){
       if(head == null || head.next == null){
           return head;
       }

       ListNode rev = reverse2(head.next);
       head.next.next = head;
       head.next = null;
       return rev;
    }

    public ListNode reverse3(ListNode head,int depth){
        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Reversing " + head);

        if(head == null || head.next == null){
            System.out.println(head);
            return head;
        }


        ListNode rev = reverse3(head.next,depth+1);
        System.out.print(depthString);
        System.out.println("Reverse : " + rev);

        head.next.next = head;
        head.next = null;

        System.out.print(depthString);
        System.out.println("Return: "+ rev);
        return rev;
    }


    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode rev = head.next;
        while (cur.next.next != null && cur != null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;

            pre = cur;
            cur = next.next;
        }

        return rev;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null){
            return head;
        }
        if(head.next.next == null){
            head.next.next = head;
            head.next = null;
        }

        ListNode rev = swapPairs2(head.next.next);
        return rev;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new ListNode()).swapPairs(head);
        System.out.println(res);

    }
}