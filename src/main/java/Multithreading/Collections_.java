package Multithreading;

import DataStructureAndAlgorithm.Heap.Queue;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Chris Yang
 * created 2022-05-22 17:14
 **/
public class Collections_ {
    public static void main(String[] args) {
        List list = null;
        Map map;
        Queue queue;
        Set set;

        List list1 = Collections.synchronizedList(list);

        // 只读器，可以容忍暂时的读写不一致，不可被删改，只是在镜像上操作
        List list2 = new CopyOnWriteArrayList();

        SafeArrayList safeArrayList;
    }
}

class SafeArrayList<T> {
    List<T> list = new ArrayList<>();

    synchronized T get(int index) {
        return list.get(index);
    }

    synchronized void set(int index, T t) {
        list.set(index,t);
    }

    synchronized boolean addIfNotExist(int index,T t){
        if(!list.contains(t)){
            list.add(index,t);
        }
        return false;
    }
}

