/**
 * @ClassName ArrayLengthDemo
 * @Description
 * @Author Bruce
 * @Date 2021/2/8 下午1:53
 */
public class ArrayLengthDemo {
    public static void main(String[] args) {
        int []array = {};
        System.out.println(array == null);//false
        System.out.println(array.length);//0
        int []array1 = new int[0];
        System.out.println(array1 == null);//false
        System.out.println(array1.length);//0
        int []array2;
//        System.out.println(array2 == null);//error
//        System.out.println(array2.length);//error
    }
}
