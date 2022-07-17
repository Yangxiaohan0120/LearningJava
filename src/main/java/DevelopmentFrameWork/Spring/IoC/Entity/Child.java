package DevelopmentFrameWork.Spring.IoC.Entity;

/**
 * @author Chris Yang
 * created 2022-07-17 16:29
 **/
public class Child {
    private String name;
    private Apple apple;

    public Child() {
    }

    public Child(String name, Apple apple) {
        this.name = name;
        this.apple = apple;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public String getName() {
        return name;
    }

    public Apple getApple() {
        return apple;
    }

    public void eat(){
        System.out.println(name + "吃到了" + apple.getOrigin() + "种植的" + apple.getTitle());
    }
}
