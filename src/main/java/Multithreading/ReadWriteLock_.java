package Multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Chris Yang
 * created 2022-05-18 15:55
 **/

// 适用于读多写少的场景的锁
public class ReadWriteLock_ {
}

// 实现通用缓存工具类

// 一次缓存
class Cache<K, V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    final Lock r = readWriteLock.readLock();
    final Lock w = readWriteLock.writeLock();

    V get(K key) {
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    V put(K key, V value) {
        w.lock();
        try {
            m.put(key, value);
        } finally {
            w.unlock();
        }
        return value;
    }
}

// 查询时缓存
class Cache2<K, V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    final Lock r = readWriteLock.readLock();
    final Lock w = readWriteLock.writeLock();

    V get(K key) {
        V v = null;
        r.lock();
        try {
            v = m.get(key);
            // 1⃣️
        } finally {
            r.unlock();
        }
        if (v != null) {
            return v;
        }
        // 不可以放在1⃣️的位置，ReadWriteLock锁不支持升级
        // 如果读锁不释放，会一直卡在写锁这里，导致线程的堵塞。
        w.lock();
        try {
            v = m.get(key);
            if( v == null){
                v = m.get(key);// 省略加载新的缓存赋值过程
                m.put(key,v);
            }
        } finally {
            w.unlock();
        }
        return v;
    }

    V put(K key, V value) {
        w.lock();
        try {
            m.put(key, value);
        } finally {
            w.unlock();
        }
        return value;
    }
}