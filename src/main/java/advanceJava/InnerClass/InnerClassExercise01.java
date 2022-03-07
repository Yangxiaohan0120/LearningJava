package advanceJava.InnerClass;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        // 匿名内部类可以当做实参，直接传递，简洁高效
        // 仅影响当前这个对象，若是硬编码，则会改变所有的Picture 类
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("匿名类做实参");
            }
        });

        f1(new Picture());

    }

    public static void f1(IL il){
        il.show();
    }
}

interface IL{
    void show();
}

// 传统方式
// 硬编码
class Picture implements IL{
    @Override
    public void show(){
        System.out.println("这个是个名画");
    }
}