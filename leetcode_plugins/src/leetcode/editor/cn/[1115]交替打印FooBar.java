package leetcode.editor.cn;//我们提供一个类：
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 1
//输出: "foobar"
//解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2: 
//
// 
//输入: n = 2
//输出: "foobarfoobar"
//解释: "foobar" 将被输出两次。
// 
// 👍 88 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//题目
//class FooBar {
//    private int n;
//
//    public FooBar(int n) {
//        this.n = n;
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//
//        	// printFoo.run() outputs "foo". Do not change or remove this line.
//        	printFoo.run();
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//
//            // printBar.run() outputs "bar". Do not change or remove this line.
//        	printBar.run();
//        }
//    }
//}


//Lock（超时）
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {

    //ReentrantLock默认非公平锁
//    private final Lock lock = new ReentrantLock();
    private final Lock lock = new ReentrantLock(true);
    private boolean flag = true;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (flag) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = false;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!flag) {
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    flag = true;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}


////信号量
//import java.util.concurrent.Semaphore;
//
//class FooBar {
//    private int n;
//
//    public FooBar(int n) {
//        this.n = n;
//    }
//
//    Semaphore foo = new Semaphore(1);
//    //设置为0后是可以release的，然后就可以acquire. 这里设置为0，就是一开始使线程阻塞从而完成其他执行。
//    Semaphore bar = new Semaphore(0);
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            foo.acquire();
//            printFoo.run();
//            bar.release();
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            bar.acquire();
//            printBar.run();
//            foo.release();
//        }
//    }
//}



//leetcode submit region end(Prohibit modification and deletion)
