package Backtracking回溯;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wushiai
 * @date 2020/4/9 20:38
 * @content 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class 全排列46 {


    /// Recursive get all the permutations in place
/// Time Complexity: O(n!)
/// Space Complexity: O(n)
    private ArrayList<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;

        generatePermutation(nums, 0);

        return res;
    }

    private void generatePermutation(int[] nums, int index){

        if(index == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int i : nums)
                list.add(i);
            res.add(list);
            return;
        }

        for(int i = index ; i < nums.length ; i ++){
            swap(nums, i, index);
            generatePermutation(nums, index + 1);
            swap(nums, i, index);
        }
        return;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    /// Most Naive Recursive
/// Time Complexity: O(n^n)
/// Space Complexity: O(n)
//    private ArrayList<List<Integer>> res;
//    private boolean[] used;
//
//    public List<List<Integer>> permute(int[] nums) {
//
//        res = new ArrayList<List<Integer>>();
//        if (nums == null || nums.length == 0)
//            return res;
//
//        used = new boolean[nums.length];
//        LinkedList<Integer> p = new LinkedList<Integer>();
//        generatePermutation(nums, 0, p);
//
//        return res;
//    }
//
//    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {
//
//        if (index == nums.length) {
//            res.add((LinkedList<Integer>) p.clone());
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!used[i]) {
//                p.addLast(nums[i]);
//                used[i] = true;
//                generatePermutation(nums, index + 1, p);
//                p.removeLast();
//                used[i] = false;
//            }
//        }
//        return;
//    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new 全排列46()).permute(nums);
        for (List<Integer> list : res)
            System.out.println(list);
    }
}
