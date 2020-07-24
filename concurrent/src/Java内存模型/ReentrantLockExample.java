package Java内存模型;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLock
 * @Description 可重入锁ReentrantLock
 * 在ReentrantLock中，调用lock()方法获取锁;调用unlock()方法释放锁
 * ReentrantLock的实现依赖于Java同步器框架AbstractQueuedSynchronizer(本文简称之为 AQS)。
 * AQS使用一个整型的volatile变量(命名为state)来维护同步状态，马上我们会看到，这个volatile变量是ReentrantLock内存语义实现的关键。
 * @Author Bruce
 * @Date 2020/7/17 10:26 上午
 */
public class ReentrantLockExample {

    int a = 0;
    ReentrantLock reentrantLock = new ReentrantLock();

    public void writer() {
        reentrantLock.lock();     // 获取锁
        try {
            a++;
        } finally {
            reentrantLock.unlock();  // 释放锁
        }
    }

    public void reader() {
        reentrantLock.lock();     // 获取锁
        try {
            int i = a;
            //......
        } finally {
            reentrantLock.unlock();  // 释放锁
        }
    }
}

