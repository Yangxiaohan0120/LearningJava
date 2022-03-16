package advanceJava.Exception;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-03-14 15:59
 **/

// 用户输入一个整数，如果不是就反复输入，直到输入正确为止

public class Try04 {
    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        String temp;
        int num;
        while (true) {
            System.out.println("请输入一个整数：");
            temp = scanner.next();
            try {
                num = Integer.parseInt(temp);
                break; // 如果没有抛出异常，则停止循环
            } catch (NumberFormatException e) {
                System.out.println("输入不是整数");
            }
        }
        System.out.println("输入的值是： " + num);
    }
}
