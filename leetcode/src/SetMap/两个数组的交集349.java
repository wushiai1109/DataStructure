package SetMap; /**
 * @author Wushiai
 * @date 2020/2/1 23:27
 * @content 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class 两个数组的交集349 {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1}, num2 = {2, 2};
        System.out.println(Arrays.toString(new 两个数组的交集349().intersection(num1, num2)));
    }

    // Hash Set
// Time complexity: O(len(nums1) + len(nums2))
// Space Complexity: O(len(nums1))
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> record = new HashSet<Integer>();
        for(int num: nums1)
            record.add(num);

        HashSet<Integer> resultSet = new HashSet<Integer>();
        for(int num: nums2)
            if(record.contains(num))
                resultSet.add(num);

        int[] res = new int[resultSet.size()];
        int index = 0;
        for(Integer num: resultSet)
            res[index++] = num;

        return res;
    }

//    public int[] intersection(int[] nums1, int[] nums2) {
//
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int num : nums1) {
//            set.add(num);
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int num : nums2) {
//            if (set.contains(num)) {
//                list.add(num);
//                set.remove(num);
//            }
//        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }
}
