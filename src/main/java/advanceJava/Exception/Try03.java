package advanceJava.Exception;

/**
 * @author Chris Yang
 * created 2022-03-14 15:38
 **/
public class Try03 {
    public static void main(String[] args) {
        System.out.println(method());
    }

    public static int method(){
        int i = 1;
        try {
            i++;
            String[] names = new String[3];
            if (names[0].equals("Tom")) { // NullPointerException
                System.out.println(names[0]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i; // 执行
        } finally {
            ++i;
            System.out.println("i = "+ i);
        }
    }
}
