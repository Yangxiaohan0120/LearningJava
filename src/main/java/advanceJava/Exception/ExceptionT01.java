package advanceJava.Exception;

/**
 * @author Chris Yang
 * created 2022-03-14 16:43
 **/
public class ExceptionT01 {
    public static void main(String[] args) {
        //
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = n1 / n2;
            System.out.println(res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确");
        } catch (ArithmeticException e) {
            System.out.println("出现了0");
        }
    }
}


