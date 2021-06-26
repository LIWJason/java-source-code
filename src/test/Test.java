package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(

                2,
                2,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i =0; i < 6; i ++) {
            try {
                threadPoolExecutor.execute(new TestRunnable());
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        threadPoolExecutor.shutdown();



        while (true){
            System.out.println(1);
        }
    }

    static class TestRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行了一下子");

        }
    }
}
