package advanceJava.VarClassMethod;

/**
 * @ author: yxh
 * @ created: 2022-02-25 : 8:16 PM
 */
class Person {
    private int id;//    private int id;
    private static int total = 0;

    public static int getTotalPerson() {
        //        id ++;
        return total;
    }

    public Person(){
        total++;
        id = total;
    }
}

public class PracticeII {

    public static void main(String[] args) {
        System.out.println("Number of total is "+ Person.getTotalPerson());// 0
        Person p1 = new Person();
        System.out.println("Number of total is "+ Person.getTotalPerson());// 1
    }

}