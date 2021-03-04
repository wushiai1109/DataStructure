package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName 按序打印1114
 * @Description 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *  
 * <p>
 * 注意:
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * <p>
 * 你看到的输入格式主要是为了确保测试的全面性。
 * @Author Bruce
 * @Date 2020/7/16 2:18 下午
 */
public class 按序打印1114 {
////    题目
//    class Foo {
//
//        public Foo() {
//
//        }
//
//        public void first(Runnable printFirst) throws InterruptedException {
//
//            // printFirst.run() outputs "first". Do not change or remove this line.
//            printFirst.run();
//        }
//
//        public void second(Runnable printSecond) throws InterruptedException {
//
//            // printSecond.run() outputs "second". Do not change or remove this line.
//            printSecond.run();
//        }
//
//        public void third(Runnable printThird) throws InterruptedException {
//
//            // printThird.run() outputs "third". Do not change or remove this line.
//            printThird.run();
//        }
//    }

    class Foo {
        //设置 CountDownLatch 等待线程数为 1
//CountDown 是倒计时的意思，Latch 是门栓的意思，加起来的意思就是一个倒计时的门栓。
//它其实是作用于线程当中的，它就像一个门栓，一开始是关闭的，所有希望通过该门的线程都需要等待，然后开始倒计时，当倒计时一到，等待的所有线程都可以通过。
//要注意的是，它是一次性的，打开之后就不能关上了。
        private final CountDownLatch second = new CountDownLatch(1);
        private final CountDownLatch third = new CountDownLatch(1);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            second.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {

            third.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
