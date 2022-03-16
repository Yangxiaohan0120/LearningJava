package advanceJava.Enum;

/**
 * @author Chris Yang
 * created 2022-03-14 11:09
 **/
public class EnumerationDetails {
    public static void main(String[] args) {
        Music.CLASSICMUSIC.playing();
    }
}

// 1. enum不允许继承其他类，单继承机制
// 2. 但是可以实现接口

class AA{

}

interface IPplaying{
    void playing();
}

enum Music implements IPplaying{ // extends AA 不可继承
    CLASSICMUSIC;

    @Override
    public void playing() {
        System.out.println("播放");
    }
}