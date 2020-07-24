package leetcode;

/**
 * @author Wushiai
 * @date 2020/1/29 13:24
 * @content
 */
public class 数字序列中某一位的数字 {

    public static void main(String[] args) {
        System.out.println(new 数字序列中某一位的数字().findNumberIndex(191));
    }

    public int findNumberIndex(int index) {
        if (index < 1)
            return -1;

        if (index <= 10)
            return index - 1;

        int length = 1;
        while (true) {
            int number = countNumber(length);
            if (index <= number * length)
                return findNumber(index, length);
            index -= number * length;
            length++;
        }

    }

//    //数据的位数
//    public int numberLength(int index) {
//        return String.valueOf(index).length();
//    }

    //length位数的数据个数之和
    public int countNumber(int length) {
        if (length == 1)
            return 10;
        return (int) (9 * Math.pow(10, length - 1));
    }

    //找到该数
    public int findNumber(int index, int length) {
        int num1 = index % length;
        if (num1 == 0)
            return 1;
        return String.valueOf(Math.pow(10, length)).charAt(num1 - 1) - 48;
    }


}
