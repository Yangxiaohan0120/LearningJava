package advanceJava.Single;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 1:54 PM
 */

// 单例设计模式
// 饿汉式和懒汉式的单例模式的实现
//1）构造器的私有化 // 不提供new一个新对象
//2）类的内部创建对象
//3）向外暴露一个静态的公共方法 // getInstance
//4）代码实现

public class SingletonPattern {

    public static void main(String[] args) {
        // 通过方法获取对象
//        GirlFriend ins = GirlFriend.getInstance();
//        System.out.println(ins);
//        GirlFriend ins1 = GirlFriend.getInstance();
//        System.out.println(ins1);
//        System.out.println(ins == ins1);

//        System.out.println(GirlFriend.n1); // 这是虽然未使用到gf，但还是会加载

//        Cat cat = Cat.getInstance();
//        System.out.println(cat);
//        Cat cat1 = Cat.getInstance();
//        System.out.println(cat1);

//        System.out.println(Cat.n2);

        //Runtime Error 也是一个经典的单例模式
        Runtime rn = Runtime.getRuntime();
    }

}

// 饿汉式单例模式
class GirlFriend {

    private String name;

    public static int n1 = getV1();

    private static int getV1() {
        System.out.println("getV1 ...");
        return 100;
    }

    // 2）在类的内部创建对象
    // 为了在静态方法中可以访问，所以需要将此变量设置为static
    private static GirlFriend gf = new GirlFriend("小红");
    // 饿汉式 未使用此对象的时候，因为加载了类，所以也会加载此对象

    // 1）将构造器私有化
    private GirlFriend(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }

    // 3) 提供一个公共的static方法，访问gf对象
    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + "\'" +
                '}';
    }

}


// 懒汉式单例模式
// 避免未使用对象就创建
class Cat {
    private String name;

    // 2) 定义一个静态属性
    private static Cat cat;

    public static int n2 = 100;

    // 1) 构造器私有化
    private Cat(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }

    // 3) 提供一个公共的static方法，访问Cat对象
    public static Cat getInstance(){
        if(cat == null) {
            cat = new Cat("咪咪");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + "\'" +
                '}';
    }
}