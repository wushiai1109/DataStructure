/**
 * @author Wushiai
 * @date 2020/2/20 21:03
 * @content 当一个String实例str调用intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量，如果有，则返回其的引用，
 * 如果没有，则在常量池中增加一个Unicode等于str的字符串并返回它的引用
 */
public class String的intern方法等细节 {
    public static void main(String[] args) {
//        String s1 = "aaabbb";
//        String s2 = new String("aaabbb");
//        String s3 = "aaa";
//        String s4 = "bbb";
//        String s5 = "aaa" + "bbb";
//        String s6 = s3 + s4;
//        System.out.println(s1 == s2);//false
//        System.out.println(s1 == s5);//true
//        System.out.println(s1 == s6);//false
//        System.out.println(s1 == s6.intern());//true
//        System.out.println(s2 == s2.intern());//false
//        System.out.println(s1 == s2.intern());//true


        //创建一个"abc"字符串对象，该对象的内存地址，让s1变量保存。
        //s1是一个引用，s1指向 "abc" 对象.
        String s1 = "abc";

        //可以让s1重新指向吗？s1是局部变量,s1前边没有final，所以s1可以重新指向。
        //但是"def"字符串本身不可变.
        s1 = "def";


        String s2 = "Hello"; //在字符串常量池中新建一个"Hello"字符串对象，该对象不可变
        String s3 = "Hello"; //从字符串常量池中直接拿来用。

        System.out.println(s2 == s3); //true

        //比较两个字符串是否相等，不能用"=="
        String s4 = new String("abc");
        String s5 = new String("abc");

        System.out.println(s4 == s5); //false

        //比较两个字符串是否一致，必须使用String类提供的equals方法.
        System.out.println(s4.equals(s5)); //true


        //以下程序执行结束之后，会在字符串常量池中创建3个字符串对象
        //"aaa" "bbb"  "aaabbb"
        String s6 = "aaa";
        String s7 = "bbb";
        String s8 = s6 + s7;

    }
}
