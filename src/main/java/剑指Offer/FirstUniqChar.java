package 剑指Offer;

import org.checkerframework.checker.units.qual.C;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-08-01 12:28
 **/
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        Queue<Character> queue = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        queue.remove('a');
        for (int i = 0; i < s.length(); i++) {
            if(!set.contains(s.charAt(i))){
                queue.add(s.charAt(i));
                set.add(s.charAt(i));
            }else {
                queue.remove(s.charAt(i));
            }
        }
        if(queue.isEmpty()){
            return ' ';
        }else {
            return queue.peek();
        }
    }
}
