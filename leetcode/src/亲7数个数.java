import java.util.*;

/**
 * @ClassName 亲7数个数
 * @Description
 * @Author Bruce
 * @Date 2020/8/1 4:32 下午
 */
public class 亲7数个数 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(new 亲7数个数().Permutation(arr));
    }

    public int Permutation(int[] str) {
        ArrayList<Integer> list = new ArrayList<>();
        if (str == null || str.length == 0) {
            return 0;
        }
        PermutationHelper(str, 0, list);
        Collections.sort(list);
        ArrayList<Integer> res = new ArrayList<>();
        for (int resDemo : list) {
            if (resDemo%7==0){
                res.add(resDemo);
            }
        }
        return res.size();
    }

    private void PermutationHelper(int[] chars, int i, ArrayList<Integer> list) {
        if (i == chars.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (int j : chars) {
                sb.append(j);
            }
            list.add(Integer.parseInt(sb.toString()));
        } else {
//            Set<Integer> charSet = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
//                if (!charSet.contains(chars[j])) {
//                    charSet.add(chars[j]);
                swap(chars, i, j);
                PermutationHelper(chars, i + 1, list);
                swap(chars, j, i);
//                }
            }
        }
    }

    private void swap(int[] cs, int i, int j) {
        int temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
