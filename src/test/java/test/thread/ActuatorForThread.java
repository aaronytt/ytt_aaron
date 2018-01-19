package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:16 2018/1/18
 * @Modiflid By:
 */
public class ActuatorForThread {

    //必要时创建新线程;空闲线程会被保留60秒
    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    //该池包含固定数量的线程；空闲线程一直被保留
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
    //只有一个线程的“池”，该线程顺序执行每一个提交的任务（雷士余Swing事件分配线程）
    private ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    //用于预定执行而构建的固定线程池，代替java.util.Timer
    private ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(20);
    //用于预定执行而构建的单线城“池”
    private ExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

}
