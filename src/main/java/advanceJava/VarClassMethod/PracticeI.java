package advanceJava.VarClassMethod;

/**
 * @ author: yxh
 * @ created: 2022-02-25 : 8:05 PM
 */
public class PracticeI {

    static int count = 9;
    public void count(){
        System.out.println("count = "+ (count ++));
    }

    public static void main(String[] args) {
        new PracticeI().count();
        new PracticeI().count();
        System.out.println(PracticeI.count);
    }

}