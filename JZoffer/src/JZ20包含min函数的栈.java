import java.util.Stack;

/**
 * @ClassName JZ20包含min函数的栈
 * @Description 栈
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @Author Bruce
 * @Date 2021/2/10 下午4:00
 */
public class JZ20包含min函数的栈 {
    class Solution {
        private Stack<Integer> data = new Stack<>();
        private Stack<Integer> min = new Stack<>();

        public void push(int node) {
            data.push(node);
            if (min.isEmpty()) {
                min.push(node);
            } else {
                min.push(node <= min.peek() ? node : min.peek());
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
