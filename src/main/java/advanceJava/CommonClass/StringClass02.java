package advanceJava.CommonClass;

/**
 * @author Chris Yang
 * created 2022-03-14 20:36
 **/

//String 字符串的特性

// final 类，代表不可变的字符序列
// 字符串不可变，一旦被分配，其内容不可更改；

public class StringClass02 {
    public static void main(String[] args) {
        // 以下语句创建了几个对象？
        // 在常量池创建了"haha" 后，重新指向
        String s1 = "hello";
        s1 = "haha";
        System.out.println(s1);

        // 以下创建了几个对象？
        // 创建了一个，编译器会在底层进行优化
        // String a = "hello" + "abc"  ==> String a = "helloabc"
        String a = "hello" + "abc";

        // 创建了几个对象？三个
        // a + b 在底层究竟是怎么执行的？
        // 1) 先创建一个StringBuilder sb = new StringBuilder()
        // 2) 执行 sb.append("hello")
        // 3) sb.append("abc")
        // 4) sb.toString() // 相当于了new
        // 最终 s3指向了堆中的对象 （String） value[]  -->  池中 "helloabc"

        String i1 = "hello";
        String i2 = "abc";
        String i3 = i1 + i2;
        String i4 = "helloabc";
        System.out.println(i3 == i4);// false
        String i5 = "hello" + "abc";
        System.out.println(i4 == i5); // true

        // 一句话总结： 常量相加，看常量池的地址； 变量相加，看堆中的地址。


    }


}

class Test1 {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        Test1 ex = new Test1();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str + "and"); // hspand copy 了对象，实际上没有更改内容
        System.out.println(ex.ch); // hava 修改了堆内的内容
    }

    // 代码解析：
    // ex(栈） -->  [str(堆） -->  value(堆)    ] -->  hsp(常量池
    //             [ ch(堆） -->   j a v a (堆)]
    // ex.change(ex.str,ex.ch)
    // 1）其中 change 方法会创建str 对象
    // str(栈） -->   value(堆) 同一个
    // str = "java"  常量池中创建"Java" 使str指向他
    // String是final类型的，当重新赋值的时候会在常量池中创建新对象，重新指向
    // 2）change方法创建ch[]对象
    // ch[](栈）-->   j a v a (堆) 同一个
    // ch[0] = 'h' 直接修改

    // 最后ex.str 未被修改   ex.ch 被修改
}
