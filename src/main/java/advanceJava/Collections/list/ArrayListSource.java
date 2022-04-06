package advanceJava.Collections.list;

import java.util.ArrayList;

/**
 * @author Chris Yang
 * created 2022-03-18 20:24
 **/
@SuppressWarnings({"all"})
public class ArrayListSource {
    // ArrayList 源码解析
    // 1. ArrayList维护了一个Object数组，所以可以添加任意类型的元素
    // transient Object[] elementData // 表示该属性不会被序列号 （serialID）
    // 2. ArrayList的扩容机制： 无参构造器： 0 ，第一次添加，扩容为10 ， 若需要扩容使用1.5倍进行添加
    // 3. 如果使用指定的构造器，则初始为指定大小，扩容使用1.5倍进行添加
    public static void main(String[] args) {
        //注意，注意，注意，Idea 默认情况下，Debug 显示的数据是简化后的，如果希望看到完整的数据
        //需要做设置.

        //使用无参构造器创建ArrayList对象
        // 源码：this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
//         ArrayList list = new ArrayList();
        ArrayList list = new ArrayList(8);
        //使用for给list集合添加 1-10数据
        for (int i = 1; i <= 10; i++) {
            list.add(i);
            // 源码：public boolean add(E e) {
            //        ensureCapacityInternal(size + 1);  // Increments modCount!!
            //        elementData[size++] = e; // 最后返回到此进行新元素的添加。
            //        return true;
            //    }
            // 添加之前查看容量是否足够

            //private static int calculateCapacity(Object[] elementData, int minCapacity) {
            //        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            //            return Math.max(DEFAULT_CAPACITY, minCapacity);
            //        }
            //        return minCapacity;
            //    }
            // 第一次扩容确定最小的容量，为10；

            //private void ensureExplicitCapacity(int minCapacity) {
            //        modCount++;
            //
            //        // overflow-conscious code
            //        if (minCapacity - elementData.length > 0)
            //            grow(minCapacity);
            //    }
            // modCount++; 确定线程被修改的次数，防止多线程操作出现异常。
            // 如果真的不够使用时，才使用grow方法进行扩容

            //private void grow(int minCapacity) {
            //        // overflow-conscious code
            //        int oldCapacity = elementData.length;
            //        int newCapacity = oldCapacity + (oldCapacity >> 1);
            //        if (newCapacity - minCapacity < 0)
            //            newCapacity = minCapacity;
            //        if (newCapacity - MAX_ARRAY_SIZE > 0)
            //            newCapacity = hugeCapacity(minCapacity);
            //        // minCapacity is usually close to size, so this is a win:
            //        elementData = Arrays.copyOf(elementData, newCapacity);
            //    }
            // 扩容的方法：（oldCapacity >> 1) 右移一位代表除以二
            // 比较 newCapacity ｜ minCapacity 没必要扩容
            // 比较 newCapacity ｜ MAX_ARRAY_SIZE 扩到最大的容量，不能无限制的扩大
            // Arrays.copyOf() 将Array进行复制，真正的扩容步骤的进行。 // 保证原先的数据不被销毁
            // 第一次扩容到10，第二次及以后按照1.5倍进行扩容
        }
        //使用for给list集合添加 11-15数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
    }
}
