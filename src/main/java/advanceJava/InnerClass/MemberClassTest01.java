package advanceJava.InnerClass;

/**
 * @author Chris Yang
 * created 2022-03-13 20:12
 **/
public class MemberClassTest01 {

    public MemberClassTest01(){
        Innerr s1 = new Innerr();
        s1.a = 10;
        Innerr s2 = new Innerr();
        System.out.println(s2.a);
    }

    class Innerr{
        public int a = 5;
    }

    public static void main(String[] args) {
        MemberClassTest01 m = new MemberClassTest01();
        Innerr r = m.new Innerr();
        System.out.println(r.a);

    }
}
