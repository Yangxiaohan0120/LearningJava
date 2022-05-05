package LeetCode;

import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-04-16 21:49
 **/
public class ReverseStack {
    public void reverseStack(Stack<Integer> s){
        int k;
        if(s.size() <= 1){ // 如果小于等于1 不需要做反转
            return;
        }else {
            k = s.peek();
            s.pop(); // 将下层的反转，并且将最上层放置到最底。
            reverseStack(s);
            PushBottom(s,k);
        }
    }

    public void PushBottom(Stack<Integer> s,int k){
        // 如果没有值，直接放到最底
        if(s.size() == 0){
            s.push(k);
        }else {
            // 先拿出来，放完再放回去
            int temp = s.peek();
            s.pop();
            PushBottom(s,k); // 每次拿出一个尝试放到下层，直到没有元素才是真正的放置。
            s.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        new ReverseStack().reverseStack(s);

        int n = s.size();
        for (int i = 0; i < n; i++) {
            int k = s.pop();
            System.out.println(k);
        }

    }
}
