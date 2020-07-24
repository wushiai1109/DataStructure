package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wushiai
 * @date 2020/2/3 21:31
 * @content 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）
 */
public class 用队列实现栈 {


    class MyStack {
        private Queue<Integer> a;//输入队列
        private Queue<Integer> b;//输出队列

        public MyStack() {
            a = new LinkedList<>();
            b = new LinkedList<>();
        }

        public void push(int x) {
            //offer       添加一个元素并返回true        如果队列已满，则返回false
            //add         增加一个元索                      如果队列已满，则抛出一个IIIegaISlabEepeplian异常
            //put         添加一个元素                       如果队列满，则阻塞
            a.offer(x);
            // 将b队列中元素全部转给a队列
            while (!b.isEmpty())
                a.offer(b.poll());
            // 交换a和b,使得a队列没有在push()的时候始终为空队列
            Queue<Integer> temp = a;
            a = b;
            b = temp;
        }

        public int pop() {
            //poll         移除并返问队列头部的元素     如果队列为空，则返回null
            //remove   移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
            //take        移除并返回队列头部的元素
            return b.poll();
        }

        public int top() {
            //peek       返回队列头部的元素              如果队列为空，则返回null
            //element  返回队列头部的元素              如果队列为空，则抛出一个NoSuchElementException异常
            return b.peek();
        }

        public boolean empty() {
            return b.isEmpty();
        }
    }

}
