package advanceJava.CodeBlock;

/**
 * @ author: yxh
 * @ created: 2022-02-26 : 8:57 PM
 */
public class CodeBlockI {

    public static void main(String[] args) {
        Movie n = new Movie("冰雪奇缘");
        Movie2 n1 = new Movie2("冰雪奇缘2",40);
        System.out.println(Cat.n1);
        System.out.println(DD.n1);
        System.out.println(DD.n1);
    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    // 三个构造器 --> 重载

    // 代码块：使用不同的构造器都会执行此段代码
    // 代码块的调用优先于构造器
    // static 代码块只执行一次，在类加载时执行，普通代码块在生成对象实例就执行一次。
    // 如果只是使用类的静态成员的时候，普通代码块并不会被执行。

    // 类什么时候被加载
    // 1. 创建对象实例时（new）
    // 2. 子类被调用的时候，父类也会被加载，并且父类先被加载
    // 3. 使用类的静态成员时也会加载父类的代码块

    static {
        System.out.println("class is loading");
    };  // ; 可去除


    {
        System.out.println("opening ...");
        System.out.println("advertisement ...");
        System.out.println("Movie started");
    };  // ; 可去除

    public Movie(String name) {
        System.out.println("name");
        this.name = name;
    }

    public Movie(String name, double price) {
        System.out.println("name + price");
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
        System.out.println("name + price + director");
        this.name = name;
        this.price = price;
        this.director = director;
    }

}

class Movie2 extends Movie{

    {
        System.out.println("Movie2");
    }

    public Movie2(String name) {
        super(name);
    }

    public Movie2(String name, double price) {
        super(name, price);
    }

    public Movie2(String name, double price, String director) {
        super(name, price, director);
    }
}


class Animal{
    static {
        System.out.println("Animal");
    }
}

class Cat extends Animal {
    public static int n1 = 999;

    static {
        System.out.println("Cat");
    }
}

class DD {
    public static int n1 = 9999;

    static {
        System.out.println("DD的静态代码块");
    }

    {
        System.out.println("DD的普通代码块");
    }
}