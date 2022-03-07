package testForsrccode.HashTable;

/**
 * @ author: yxh
 * @ created: 2021-12-16 : 10:02 AM
 */
public class HashTable {

    int[] elem;
    public int count = 0;
    public int size = 12;
    public final int NULLKEY = Integer.MIN_VALUE;

    public HashTable() {
        this.elem = new int[size];
        for (int i = 0; i < size; i++) {
            this.elem[i] = NULLKEY;
        }
    }

    public void insertHashTable(int key) {
        if (count == size) {
            return;
        }
        int index = key % size;
        while (this.elem[index] != NULLKEY) {
            index = (index + 1) % size;
        }
        this.elem[index] = key;
        count++;
    }

    public String searchHashTable(int key) {
        int index = key % size;
        while (this.elem[index] != key) {
            index = (index + 1) % size;
            if (this.elem[index] == NULLKEY || index == key % size) {
                return "Not exist";
            }
        }
        return "existing with index: "+index;
    }
}