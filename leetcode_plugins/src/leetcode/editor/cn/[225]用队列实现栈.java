package leetcode.editor.cn;//使用队列实现栈的下列操作：
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计 
// 👍 266 👎 0


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度：入栈操作 O(n)，其余操作都是 O(1)。
//入栈操作需要将队列中的 n 个元素出队，并入队 n+1 个元素到队列，共有 2n+1 次操作，
// 每次出队和入队操作的时间复杂度都是 O(1)，因此入栈操作的时间复杂度是 O(n)。
//出栈操作对应将队列的前端元素出队，时间复杂度是 O(1)。
//获得栈顶元素操作对应获得队列的前端元素，时间复杂度是 O(1)。
//判断栈是否为空操作只需要判断队列是否为空，时间复杂度是 O(1)。
//空间复杂度：O(n)，其中 n 是栈内的元素。需要使用一个队列存储栈内的元素。
class MyStack {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

//时间复杂度：入栈操作 O(n)，其余操作都是 O(1)。
//入栈操作需要将 queue1中的 n 个元素出队，并入队 n+1 个元素到 queue2
//，共有 2n+1 次操作，每次出队和入队操作的时间复杂度都是 O(1)，因此入栈操作的时间复杂度是 O(n)。
//出栈操作对应将 queue1 的前端元素出队，时间复杂度是 O(1)。
//获得栈顶元素操作对应获得 queue1 的前端元素，时间复杂度是 O(1)O(1)。
//判断栈是否为空操作只需要判断 queue1是否为空，时间复杂度是 O(1)。
//空间复杂度：O(n)，其中 n 是栈内的元素。需要使用两个队列存储栈内的元素。
class MyStack1 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack1() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
