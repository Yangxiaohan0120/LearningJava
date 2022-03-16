package advanceJava.CommonClass;

/**
 * @author Chris Yang
 * created 2022-03-14 21:21
 **/

// StringBuffer
//    extends AbstractStringBuilder
//    implements java.io.Serializable, CharSequence

// char[] value 不是final类型，存放在堆中
// StringBuffer是final类的不可被继承


// StringBuilder 和 StringBuffer 类似，不赘述


// StringBuilder 、 StringBuffer 、 String 的比较
// String 不可变字符，效率低，复用率高
// StringBuffer 可变字符序列，效率较高，线程安全
// StringBuilder 可变字符序列，效率最高，线程不安全

public class StringBuffer01 {

    public static void main(String[] args) {

        // 1. 构造器1 容量为16
        StringBuffer stringBuffer = new StringBuffer();

        // 2. 构造器2 指定char[] 大小
        StringBuffer stringBuffer1 = new StringBuffer(100);

        // 3. 构造器3 指定str + 16
        StringBuffer stringBuffer2 = new StringBuffer("java");


        // 4. StringBuffer 与 String 的相互转换
        String str = "hello tom";

        // 1) String to StringBuffer
        StringBuffer sb = new StringBuffer(str); // 对str本身没有影响
        StringBuffer sb1 = new StringBuffer();
        sb1.append(str);

        // 2) StringBuffer to String
        String s = sb1.toString();
        String s1 = new String(sb1);

        // 5. StringBuffer 类的常用方法
        sb1.append("a");
        sb1.delete(4,5);
        sb1.replace(0,1,"a");
        sb1.insert(0,"java");
        sb1.indexOf("java");

    }
}
