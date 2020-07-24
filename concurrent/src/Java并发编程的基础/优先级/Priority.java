package Java并发编程的基础.优先级;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Priority
 * @Description 从输出可以看到线程优先级没有生效，优先级1和优先级10的Job计数的结果非常相近， 没有明显差距。这表示程序正确性不能依赖线程的优先级高低。
 * @Author Bruce
 * @Date 2020/7/18 9:30 上午
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws Exception {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        //TimeUnit是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段
        //主要作用:
        //时间颗粒度转换
        //延时

        //延时5秒，与Thread.sleep( 5 * 1000 )一样
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for (Job job : jobs) {
            System.out.println("Job Priority : " + job.priority + ", Count : " + job.jobCount);
        }
    }

    static class Job implements Runnable {
        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}
