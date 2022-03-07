package testForsrccode.HashTable;
/**
 * @ author: yxh
 * @ created: 2021-12-16 : 10:11 AM
 */
public class hashTableTestMain {

    public hashTableTestMain(String[] args) {
        HashTable a = new HashTable();
        a.insertHashTable(12);
        a.insertHashTable(67);
        a.insertHashTable(56);
        a.insertHashTable(16);
        a.insertHashTable(25);
        a.insertHashTable(37);
        a.insertHashTable(22);
        a.insertHashTable(29);
        a.insertHashTable(15);
        a.insertHashTable(47);
        a.insertHashTable(48);
        a.insertHashTable(34);
        System.out.println(a.searchHashTable(12));
        System.out.println(a.searchHashTable(67));
        System.out.println(a.searchHashTable(56));
        System.out.println(a.searchHashTable(16));
        System.out.println(a.searchHashTable(25));
        System.out.println(a.searchHashTable(37));
        System.out.println(a.searchHashTable(22));
        System.out.println(a.searchHashTable(29));
        System.out.println(a.searchHashTable(15));
        System.out.println(a.searchHashTable(47));
        System.out.println(a.searchHashTable(48));
        System.out.println(a.searchHashTable(34));

    }

    public static void main(String[] args) {
        new hashTableTestMain(args);
    }
}