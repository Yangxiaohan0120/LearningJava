package Alibrary.searching;

/**
 * @ author: yxh
 * @ created: 2021-12-27 : 7:47 PM
 */
public class BinarySearch {

    public BinarySearch() {

    }

    //递归实现
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    public static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;

        if (target.compareTo(data[mid]) == 0)
            return mid;

        if (target.compareTo(data[mid]) < 0)
            return searchR(data, l, mid - 1, target);

        return searchR(data, mid + 1, r, target);
    }

    //非递归实现
    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (target.compareTo(data[mid]) == 0)
                return mid;

            if (target.compareTo(data[mid]) < 0)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return -1;
    }

    public static <E extends Comparable<E>> int search2(E[] data, E target) {
        int l = 0, r = data.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (target.compareTo(data[mid]) == 0)
                return mid;

            if (target.compareTo(data[mid]) < 0)
                r = mid;
            else
                l = mid + 1;
        }

        return -1;
    }

    // > target 的最小值
    // X X X [target] res X X
    // X X X [target-0.01] res X X
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                //data[0,mid]都小于等于target
                //有可能data[mid] == target; l = r = mid + 1;
                l = mid + 1;
            } else r = mid;
        }
        return l;
    }

    // < target 的最大索引值
    // X X X res [target] X X
    // X X X res [target+0.01] X X
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0) {
                //data[mid,data.length-1]都大于等于target
                //有可能data[mid] == target; l = r = mid - 1;
                l = mid;
            } else r = mid - 1;
        }
        return l;
    }

    // 存在target返回最大的索引
    // 不存在target返回upper（刚刚超过target的数字）
    // 上1法（五入法）
    //X X X [target] [target] [target_res] X X
    //X X X [target-0.01] [target-0.01] [target+0.01_res] X X
    //原名为ceil和lower_floor呼应（最顶上或者超过）
    public static <E extends Comparable<E>> int upper_ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            //如果upper左边的值和target一样，存在，u-1就是最大索引
            return u - 1;
            //如果不想等，则不存在，返回upper
        } else return u;
    }

    // 存在target返回最小的索引
    // 不存在target返回lower（刚刚超过target的数字）
    // X X X [target_res] [target] [target] X X
    // X X [target-0.01_res] [target+0.01] [target+0.01] X X
    // 与upper_ceil相呼应，最低或者小于
    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {
        int l = lower(data, target);
        if (l + 1 < data.length && data[l + 1].compareTo(target) == 0) {
            return l + 1;
        }
        return l;
    }

    // 存在target返回最小的索引
    // 不存在target返回upper（刚刚超过target的数字）
    // X X X [target_res] [target] [target] X X
    // X X X [target-0.01] [target-0.01] res X X
    // 最低或者超过（应该叫做upeer_floor呢）
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {
        int l = 0, r = data.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target.compareTo(data[mid]) > 0) {
                //只有在大于的时候才往右移动，如果相等，也是向左移动（比如5，5，5，5，5中查找5，无论是哪个五都会向左移动
                //直到移到5的左边，然后向右移动一位，则就是第一个5，最小的索引
                l = mid + 1;
            } else r = mid;
        }
        return l;
    }


    // 存在target返回最大的索引
    // 不存在target返回lower（刚刚超过target的数字）
    // X X X [target] [target] [target_res] X X
    // X X X res [target+0.01] [target+0.01]  X X
    // 最高或者小于 (叫做lower_ceil更合适呢）
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {
        int l = -1, r = data.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                //data[mid,r]都小于等于target，不断向右边界逼近。
                //如果存在target则是在所有target值中的最右边
                //如果不存在则是小于target的右边界
                l = mid;
            } else r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++)
            System.out.print(BinarySearch.upper_floor(arr, i) + " ");
        System.out.println();
    }
}