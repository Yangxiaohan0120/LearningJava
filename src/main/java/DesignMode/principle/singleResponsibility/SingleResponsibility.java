package DesignMode.principle.singleResponsibility;

/**
 * @author Chris Yang
 * created 2022-05-24 16:35
 **/
public class SingleResponsibility {
    public static void main(String[] args) {
        Bird bird1 = new FlyingBird("大雁");
        Bird bird2 = new WalkingBird("鸵鸟");

        bird1.move();
        bird2.move();
    }
}

interface Bird{
    void move();
}

class WalkingBird implements Bird{

    private String name;

    public WalkingBird(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " is walking");
    }
}

class FlyingBird implements Bird{

    private String name;

    public FlyingBird(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " is flying");
    }
}

