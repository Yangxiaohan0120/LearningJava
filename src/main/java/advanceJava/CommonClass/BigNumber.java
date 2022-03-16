package advanceJava.CommonClass;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Chris Yang
 * created 2022-03-15 19:52
 **/
public class BigNumber {
    public static void main(String[] args) {
//        long l = 233333333333333333333333;
        //当编程中需要处理很大的整数
        BigInteger bigInteger =  new BigInteger("233333333333333333333333");
        BigInteger bigInteger1 = new BigInteger("233333333333333333333333");
        System.out.println(bigInteger.add(bigInteger1));
        System.out.println(bigInteger.subtract(bigInteger1));
        System.out.println(bigInteger.multiply(bigInteger1));
        System.out.println(bigInteger.divide(bigInteger1));
        // 除法的无限循环小数
        BigDecimal bigDecimal = new BigDecimal("1999999.99999999");
        BigDecimal bigDecimal1 = new BigDecimal("1.1");
        System.out.println(bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING));
    }
}

