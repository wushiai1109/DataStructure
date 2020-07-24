package SetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Wushiai
 * @date 2020/2/1 23:41
 * @content 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 */

public class 两个数组的交集II350 {

    public static void main(String[] args) {
        int[] num1 = {4, 9, 5}, num2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new 两个数组的交集II350().intersect(num1, num2)));
    }

//    /// Using Hash Map
///// Time Complexity: O(len(nums1) + len(nums2)*log(len(nums1)))
///// Space Complexity: O(len(nums1)) 
//    public int[] intersect(int[] nums1, int[] nums2) {
//
//        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
//        for(int num: nums1)
//            record.put(num, record.getOrDefault(num, 0) + 1);
//
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        for(int num: nums2)
//            if(record.containsKey(num) && record.get(num) > 0){
//                result.add(num);
//                record.put(num, record.get(num) - 1);
//            }
//
//        int[] ret = new int[result.size()];
//        int index = 0;
//        for(Integer num: result)
//            ret[index++] = num;
//
//        return ret;
//    }

    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
