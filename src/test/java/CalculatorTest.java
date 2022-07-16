import DevelopmentFrameWork.Mybatis.JUnit4.Calculator;
import org.junit.Test;

/**
 * @author Chris Yang
 * created 2022-07-15 10:36
 **/

// 注解中的Test对应的必须是public修饰的方法


// 使用了Test注解的类必须满足：
// 1) 必须是无参数的非静态方法。
// 2) 添加@Test注解的类，必须拥有一个无参数的公开构造

public class CalculatorTest {

    private Calculator cal = new Calculator();

    @Test
    public void testAdd(){
        int result = cal.add(1,2);
        System.out.println(result);
    }

    @Test
    public void testSubtract(){
        int result = cal.subtract(1,2);
        System.out.println(result);
    }

    @Test
    public void testMultiply(){
        int result = cal.multiply(1,2);
        System.out.println(result);
    }

    @Test
    public void testDivide(){
        float result = cal.devide(1,2);
        System.out.println(result);
    }
}
