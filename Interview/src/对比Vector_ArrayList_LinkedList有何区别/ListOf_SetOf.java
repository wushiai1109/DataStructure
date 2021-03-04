package 对比Vector_ArrayList_LinkedList有何区别;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListOf_SetOf
 * @Description
 * @Author Bruce
 * @Date 2020/12/23 上午9:03
 */
public class ListOf_SetOf {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        System.out.println(list);

        List<String> simpleList = List.of("Hello", "world");
        System.out.println(simpleList);

    }

}
