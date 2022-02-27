package advanceJava.FinalWord;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 2:30 PM
 */

// final 关键字的使用
// 1） 类不被继承
// 2） 父类方法不被子类覆盖/重写
// 3） 类属性值不被修改
// 4） 局部变量不被修改

public class FinalWord {

    public static void main(String[] args) {

    }
}

// 1) 类不被继承
final class A {

}
//
//class B extends A{
//
//}

// 2）类方法不被覆盖
class A01 {
    public final void hi() {
        System.out.println("hi");
    }
}

//class B extends A01 {
//    @Override
//    public void hi() {
//        System.out.println("Bhi");
//    }
//}

// 3） 类属性值不被修改
class A02{
    public final double TAX_RATE = 0.08;
}

//class B {
//    public static void main(String[] args) {
//        A02 n = new A02();
//        n.TAX_RATE = 0.09; // 不可修改
//    }
//}

// 4） 局部属性不被修改
class A03{
    public void cry(){
        // 这时，NUM也被称为局部常量，常量的书写一般使用大写
        final double NUM = 0.01;
//        NUM = 0.02;
        System.out.println(NUM);
    }
}