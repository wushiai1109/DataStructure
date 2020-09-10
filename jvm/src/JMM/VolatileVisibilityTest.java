package JMM;

/**
 * @ClassName VolatileVisibilityTest
 * @Description
 * @Author Bruce
 * @Date 2020/8/25 11:27 上午
 */
public class VolatileVisibilityTest {

    //-server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,*VolatileVisibilityTest.prepareData
    //当作是共享变量
    private static volatile boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waiting data...");
                while (!initFlag) {
                }
                System.out.println("~~~~~~~success");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareData();
            }
        }).start();
    }

    public static void prepareData() {
        System.out.println("preparing data...");
        initFlag = true;
        System.out.println("prepare data end");
    }

}
