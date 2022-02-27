package advanceJava.FinalWord;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 3:02 PM
 */
public class FinalTestII {

    public int addOne(final int x) {
//    ++x; // 修改了final x;
        return x + 1;
    }

    public static void main(String[] args) {
        System.out.println(new FinalTestII().addOne(1));
    }
}