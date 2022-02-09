package test.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ author: yxh
 * @ created: 2021-12-15 : 4:52 PM
 */
public class hashtableMain {

    public hashtableMain(String[] args) {
        this.GenerateHashtable();
    }

    public void GenerateHashtable(){
        HashSet<String> a = new HashSet<>();
        a.add("111");
        System.out.println(a.hashCode());
    }

    public static void main(String[] args) {
        new hashtableMain(args);

    }
}