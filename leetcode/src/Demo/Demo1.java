package Demo;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName Demo1
 * @Description 探究interface的父类是不是Object
 * @Author Bruce
 * @Date 2020/11/9 12:03 下午
 */
public class Demo1 {

//    public interface SuperInter {
//        public void test();
//        public String getString();
//    }
//
//    public static void main(String[] args) {
//
//        Method[] methods = SuperInter.class.getMethods();
//
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//    }


//    public class A {
//        public void Hello() {
//            System.out.println("Hello");
//        }
//
//        public void World() {
//            System.out.println("World");
//        }
//    }
//
//    public static void main(String[] args) {
//        Method[] methods = A.class.getMethods();
//
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//    }

    abstract class C {
        abstract void Hello();
    }

    public static void main(String[] args) {
        Method[] methods = C.class.getMethods();

        for (Method me : methods) {
            System.out.println(me.getName());
        }
//        System.out.println(Arrays.toString(C.class.getMethods()));
    }

    Object object = new Object();

}
