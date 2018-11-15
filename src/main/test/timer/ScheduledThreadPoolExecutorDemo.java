package timer;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xhua on 2018-11-05.
 * Describe:
 */
public class ScheduledThreadPoolExecutorDemo {

    ScheduledExecutorService poolExecutor = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("task-poll-%d").daemon(true).build());

    RunnableDemo runnableDemo = new RunnableDemo(1);

    public void test(){

        //执行的线程类，经过多少时间执行，间隔周期，时间单位
        poolExecutor.scheduleAtFixedRate(runnableDemo,5,10, TimeUnit.MINUTES);
        //执行完上一个线程才开始下一个线程
        poolExecutor.scheduleWithFixedDelay(runnableDemo,5,10,TimeUnit.MINUTES);
    }

}
