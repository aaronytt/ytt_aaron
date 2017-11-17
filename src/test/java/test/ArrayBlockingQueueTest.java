package test;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {

    //容器
    private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);

    public static void main(String[] args) {

        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();

    }

}


class Producer implements Runnable{

    //容器
    private final ArrayBlockingQueue<Integer> queue;

    public Producer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true){
            produce();
        }
    }

    public void produce(){
        /**
         * put()方法是如果容器满了的话就会把当前线程挂起
         * offer()方法是容器如果满的话就会返回false，也正是我在前一篇中实现的那种策略。
         */
        try {
            Integer num = (int)(Math.random()*100+1);
            queue.put(num);
            System.out.println(">>>>>>Producer:"+num);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    //容器
    private final ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true){
            consume();
        }
    }

    public void consume(){
        /**
         * take()方法和put()方法是对应的，从中拿一个数据，如果拿不到线程挂起
         * poll()方法和offer()方法是对应的，从中拿一个数据，如果没有直接返回null
         */
        try {
            Integer num = queue.take();
            System.out.println("======consumer:"+num);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

