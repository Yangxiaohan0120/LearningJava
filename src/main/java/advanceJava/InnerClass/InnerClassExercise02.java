package advanceJava.InnerClass;

/**
 * @author Chris Yang
 * @program: PlantGenetics
 * @description:
 * @create: 2022-03-04 22:33
 **/

public class InnerClassExercise02 {
    public static void main(String[] args) {
        f1(new Cellphone());
    }

    public static void f1(Cellphone cellphone){
        cellphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        cellphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}
interface Bell{
    void ring();
}

class Cellphone {
    public void alarmclock(Bell bell){
        bell.ring();
    }
}