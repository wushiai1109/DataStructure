package SegmentTree;

/**
 * @author Wushiai
 * @date 2020/2/7 23:13
 * @content
 */
public class Main {

    public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<Integer>(nums,
                (a, b) -> a + b);
//        System.out.println(segTree);

        //-2+0+3=1
        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));

    }
}
