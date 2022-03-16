package advanceJava.Exception;

/**
 * @author Chris Yang
 * created 2022-03-14 15:35
 **/
public class Try01 {
    public static void main(String[] args) {
        System.out.println(method()); // 4 finally
    }

    public static int method() {
        try {
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
            return 3;
        } finally {
            return 4; // 必须执行，所以还是会返回4
        }
    }
}
