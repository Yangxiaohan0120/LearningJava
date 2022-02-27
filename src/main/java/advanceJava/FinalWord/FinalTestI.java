package advanceJava.FinalWord;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 2:58 PM
 */

public class FinalTestI {

    public static void main(String[] args) {
        System.out.println(new Circle(2).getArea());
    }

}

class Circle {
    private double radius;
    private final double PI = 3.14; // 定义时给值
    private final double PI01;
    private final double PI02;

    {
        PI02 = 3.14;
    }

    public Circle(double radius) {
        this.radius = radius;
        PI01 = 3.14;
    }

    public double getArea() {
        return PI * radius * radius;
    }
}