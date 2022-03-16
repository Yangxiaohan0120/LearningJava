package advanceJava.CommonClass;

/**
 * @author Chris Yang
 * created 2022-03-14 21:11
 **/

// String类的常用方法


public class StringClass03 {
    public static void main(String[] args) {
        String s = new String("wulala");
//        for (int i = 0; i < 10000; i++) {
//            s += i+"";
//        } // 可以使用StringBuilder 或者 StringBuffer
        // 不断的赋值重新指向消耗内存。
        s.charAt(0);

        int age = 25;
        double score = 99.99;

        // 1，%s, %d, %.2f %c 为占位符
        // 2，这些占位符由后面的变量来替换
        // 3，%s 表示后面由字符串来替换
        // 4，%d 表示用整数来替换
        // 5，%.2f 使用两位小数来替换 (并且进行四舍五入的处理)
        // 6，%c 表示char类型来替换

        System.out.println(String.format("我的年龄是%s,成绩是%.2f",age,score));
    }
}


