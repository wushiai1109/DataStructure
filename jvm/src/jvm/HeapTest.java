package jvm;

import java.util.ArrayList;

/**
 * @ClassName HeapTest
 * @Description
 * @Author Bruce
 * @Date 2020/8/24 2:11 下午
 */
public class HeapTest {

    //100KB
    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true){
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }
    }

}
