package advanceJava.Collections.list;

/**
 * @author Chris Yang
 * created 2022-03-18 21:11
 **/
public class LinkedListDemo {
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("hsp");

        jack.next = tom;
        tom.next = hsp;
        hsp.pre = tom;
        tom.pre = jack;

        Node first = jack; // 双向链表的头节点
        Node last = hsp; // 双向链表的尾节点

        // 从头到脚的遍历
        System.out.println("===从头到尾进行遍历===");
        while(true){
            if(first == null)break;

            System.out.println(first);
            first = first.next;
        }

        System.out.println("====从尾到头的遍历====");
        while (true) {
            if(last == null) {
                break;
            }
            //输出last 信息
            System.out.println(last);
            last = last.pre;
        }

        Node smith = new Node("smith");
        //下面就把 smith 加入到双向链表了
        smith.next = hsp;
        smith.pre = tom;
        hsp.pre = smith;
        tom.next = smith;

    }
}


class Node {
    public Object item;
    public Node next;
    public Node pre;

    public Node(Object name) {
        this.item = name;
    }

    public String toString() {
        return "Node name " + item;
    }
}