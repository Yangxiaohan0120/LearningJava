package advanceJava.Collections.homework;

import advanceJava.Collections.MapTable.HashMapSource1;

import java.security.Key;
import java.util.HashMap;

/**
 * @author Chris Yang
 * created 2022-04-11 13:48
 **/
public class homework3 {
    public static void main(String[] args) {
        HashMap<String,Integer> m = new HashMap();
        m.put("Jack",650);
        m.put("Tom",1200);
        m.put("Smith",2900);
        System.out.println(m);

        m.put("Jack",2600);
        System.out.println(m);

        for(String key : m.keySet()){
            m.put(key,(Integer) m.get(key)+100);
        }

        for(String key : m.keySet()){
            System.out.println(key);
        }

        for (int v : m.values()){
            System.out.println(v);
        }

    }
}

/**
 * 按要求完成下列任务
 * 1）使用HashMap类实例化一个Map类型的对象m，键（String）和值（int）分别用于存储员工的姓名和工资，
 * 存入数据如下：	jack—650元；tom—1200元；smith——2900元；
 * 2）将jack的工资更改为2600元
 * 3）为所有员工工资加薪100元；
 * 4）遍历集合中所有的员工
 * 5）遍历集合中所有的工资
 */