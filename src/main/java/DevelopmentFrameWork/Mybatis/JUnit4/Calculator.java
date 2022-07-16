package DevelopmentFrameWork.Mybatis.JUnit4;

/**
 * @author Chris Yang
 * created 2022-07-15 10:35
 **/
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public float devide(int a, int b) {
        if(b == 0){
            throw new ArithmeticException("除数不能为零");
        }
        return a * 1.0f / b;
    }
}
