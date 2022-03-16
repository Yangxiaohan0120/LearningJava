package advanceJava.Annotation;

/**
 * @author Chris Yang
 * created 2022-03-14 11:25
 **/
public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
        a.hi(); // 标记已被弃用，过时，不代表不可以使用。不推荐使用。
        a.hello();
    }
}

class A{
    public int n1 = 10;

    @Deprecated
    public void hi(){
        System.out.println("hi");
    }

    public void hello(){
        System.out.printf("hello");
    }


    //@Documented
    //@Retention(RetentionPolicy.RUNTIME)
    //@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
    //public @interface Deprecated {
    //}
    // 源码： @interface注解类
}
