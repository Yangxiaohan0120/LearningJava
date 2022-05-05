package advanceJava.CodeBlock;

/**
 * @author Chris Yang
 * created 2022-05-03 18:24
 **/

class Window{
    Window(int marker){
        System.out.println("Window ("+marker+")");
    }
}

class House{
    Window w1 = new Window(1);
    House(){
        System.out.println("House()");
        Window w3 = new Window(33);
    }
    Window w2 = new Window(2);
    void f(){
        System.out.println("f()");
    }
    Window w3 = new Window(3);
}

public class ClassLoading {
    public static void main(String[] args) {
        House house = new House();
        house.f();

        // 先初始化类中的实例，再初始化构造函数
        // 调用方法时才加载
    }
}
