package concurrent;

/**
 * @ClassName 三个线程顺序打印ABC
 * @Description
 * @Author Bruce
 * @Date 2020/7/16 7:53 下午
 */
public class 三个线程顺序打印ABC {

//    设置三个boolean变量和一个锁。flag控制那个线程可以走，那个应该停下来。然后在打印后才i++。直到i<10的时候，线程停止。

    private static Boolean flagA=true;
    private static Boolean flagB=false;
    private static Boolean flagC=false;

    public static void main(String[] args) {

        final Object lock = new Object();

        Thread aThread=new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0;i<10;) {

                    synchronized (lock) {

                        if (flagA) {
                            //线程A执行
                            System.out.println("A");
                            flagA=false;
                            flagB=true;
                            flagC=false;
                            lock.notifyAll();
                            i++;
                        }else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                }


            }
        });


        Thread bThread=new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0;i<10;) {

                    synchronized (lock) {
                        if (flagB) {
                            //线程执行
                            System.out.println("B");
                            flagA=false;
                            flagB=false;
                            flagC=true;
                            lock.notifyAll();
                            i++;

                        }else {

                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }

                    }



                }


            }
        });


        Thread cThread=new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0;i<10;) {

                    synchronized (lock) {

                        if (flagC) {
                            //线程执行
                            System.out.println("C");
                            flagA=true;
                            flagB=false;
                            flagC=false;
                            lock.notifyAll();
                            i++;

                        }else {

                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }


                    }

                }

            }
        });

        cThread.start();
        bThread.start();
        aThread.start();
    }

//这个思路比较简单。三个线程。启动a,打印完A后；启动b，打印完B后；启动c。虽然能实现顺序打印，但是会之后还会重复创建线程。

    //    private Thread aThread, bThread, cThread;
//    public void test1() {
//
//        aThread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("A");
//                try {
//                    bThread.start();
//                    bThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        bThread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("B");
//                try {
//                    cThread.start();
//                    cThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        cThread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("C");
//            }
//        });
//
//        aThread.start();
//    }
}
