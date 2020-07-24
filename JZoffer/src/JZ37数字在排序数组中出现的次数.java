
/**
 * @ClassName JZ37数字在排序数组中出现的次数
 * @Description 数组
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 * @Author Bruce
 * @Date 2020/7/16 12:51 下午
 */
public class JZ37数字在排序数组中出现的次数 {
    public static void main(String[] args) {
//        int array[] = {2, 4, 5, 5, 5, 7, 9};
//        System.out.println(new JZ37数字在排序数组中出现的次数().GetNumberOfK(array, 5));

//        int array[] = {3, 3, 3, 3, 4, 5};
//        System.out.println(new JZ37数字在排序数组中出现的次数().GetNumberOfK(array, 3));

        int array[] = {3, 3, 3, 3};
        System.out.println(new JZ37数字在排序数组中出现的次数().GetNumberOfK(array, 4));
    }

    //滑动窗口
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int i = 0;
        int j = array.length - 1;
        while (array[i] != array[j]) {
            if ((array[j] > k && array[i] > k) || (array[j] < k && array[i] < k)) {
                return 0;
            }
            if (array[i] < k) {
                i++;
            }
            if (array[j] > k) {
                j--;
            }
        }
        if (array[i] != k) {
            return 0;
        }
        return j - i + 1;
    }


//    public int GetNumberOfK(int[] array, int k) {
//        int count = 0;
//        int index = array.length / 2;
//        while (true) {
//            if (array[index] > k) {
//                index = (index + 1) / 2;
//            } else if (array[index] < k) {
//                index = (index - 1) / 2;
//            } else {
//                count++;
//                int temp = index;
//                while (true) {
//                    if (index < array.length - 1 && temp > 0 && array[++index] == k && array[--temp] == k) {
//                        count += 2;
//                    } else if (index < array.length - 1 && array[++index] == k) {
//                        count++;
//                    } else if (temp > 0 && array[--temp] == k) {
//                        count++;
//                    } else {
//                        break;
//                    }
//                }
//                break;
//            }
//        }
//        return count;
//    }
}
