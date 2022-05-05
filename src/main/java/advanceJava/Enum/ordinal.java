package advanceJava.Enum;

/**
 * @author Chris Yang
 * created 2022-05-03 18:46
 **/

enum Spiciness {
    NOT, MILD, MEDIUM, HOT, FLAMING;
}

public class ordinal {
    public static void main(String[] args) {
        for(Spiciness s : Spiciness.values())
            System.out.println(s + "，ordinal: " + s.ordinal());
    }
}
