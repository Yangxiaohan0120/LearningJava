package advanceJava.Annotation;

/**
 * @author Chris Yang
 * created 2022-03-14 11:17
 **/
public class Override_ {
    public static void main(String[] args) {
        Son son = new Son();
        son.fly();
    }
}

class Father {
    public void fly() {
        System.out.println("Father fly ...");
    }
}

class Son extends Father {
    // 表示重写父类，即使没有这个标志，也是重写。
    // Override 标识之后，编译器会检查是否真的重写了父类方法。
    // @Override 的定义 如果发现@interface表示一个注解类


    //@Target(ElementType.METHOD)
    //@Retention(RetentionPolicy.SOURCE)
    //public @interface Override {
    // Target 修饰注解的注解，元注解
    @Override
    public void fly() {
        System.out.println("Son fly ...");
    }

    // 并没有真的Override
    /* @Override
      public void say(){
      }
    */
}
