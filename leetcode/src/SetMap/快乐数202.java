package SetMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Wushiai
 * @date 2020/3/5 14:33
 * @content 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例: 
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class 快乐数202 {
    //这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
    //如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），
    //也就是两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
    public static void main(String[] args) {
        System.out.println(new 快乐数202().isHappy(33));
    }

//    //快慢指针
//    public boolean isHappy(int n) {
//        int fast = n;
//        int slow = n;
//        do {
//            slow = squareSum(slow);
//            fast = squareSum(fast);
//            fast = squareSum(fast);
//        } while (slow != fast);
//        return fast == 1;
//    }
//
//    private int squareSum(int m) {
//        int squaresum = 0;
//        while (m != 0) {
//            squaresum += (m % 10) * (m % 10);
//            m /= 10;
//        }
//        return squaresum;
//    }

    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (n != 1) {
            int temp = 0;
            while (n > 0) {
                temp += Math.pow(n % 10, 2);
                n = n / 10;
            }
            if (map.containsKey(temp)) {
                return false;
            } else {
                map.put(temp, 1);
            }
            n = temp;
        }
        return true;
    }
}
