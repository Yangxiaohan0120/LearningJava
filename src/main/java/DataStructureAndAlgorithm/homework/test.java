package DataStructureAndAlgorithm.homework;

/**
 * @ author: yxh
 * @ created: 2021-12-15 : 10:00 PM
 */

class student1 {

    private Object id;

    public Object getID() {
        return id;
    }

    public student1(Object id) {
        this.id = id;
    }

    public boolean equals(Object a) {
        if (a == null || !(a instanceof student1)) {
            return false;
        } else {
            return this.getID().equals(((student1) a).getID());
        }
    }
}

public class test {
    public static void main(String[] args) {
        student1 a = new student1(1);
        student1 b = new student1(1);
        System.out.println(a.equals(b));
    }
}


