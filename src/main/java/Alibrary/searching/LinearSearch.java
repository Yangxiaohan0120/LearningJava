package Alibrary.searching;

/**
 * @ author: yxh
 * @ created: 2021-12-26 : 11:57 AM
 */
public class LinearSearch {

    private LinearSearch() {

    }

    /**
     * @description 使用<E></E>来做为泛性的输入，其中泛性不包括基本数据类型，只能用包装类
     * @author yxh
     * @date 2021-12-15 21:57:48
     * @para * @param: array * @param: k
     * @return
     */
    public static <E> int search(E[] array, E k) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(k)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 666);
        System.out.println(res2);
    }
}