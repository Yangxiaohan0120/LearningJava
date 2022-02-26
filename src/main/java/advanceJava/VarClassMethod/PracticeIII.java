package advanceJava.VarClassMethod;

import java.sql.PreparedStatement;

/**
 * @ author: yxh
 * @ created: 2022-02-25 : 8:23 PM
 */
class Person1 {
    private int id;//    private int id;
    private static int total = 0;

    public static void setTotalPerson(int total){
//        this.total = total; // 静态变量不可以使用this关键字

        Person1.total = total;
    }

    public Person1() {
        total++;
        id = total;
    }
}

public class PracticeIII {

    public static void main(String[] args) {
        Person1.setTotalPerson(3); //3
        new Person1(); //4
    }
}