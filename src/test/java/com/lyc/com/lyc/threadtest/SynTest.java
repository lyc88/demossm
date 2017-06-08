package com.lyc.com.lyc.threadtest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.lyc.com.lyc.threadtest.SynTest.countDownLatch1;
import static com.lyc.com.lyc.threadtest.SynTest.lock;

/**
 * Created by lyc on 2017/6/8.
 * 高并发下测试
 */
public class SynTest {
    public int i;
    static CountDownLatch countDownLatch1 = new CountDownLatch(10);
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        int count = 10;

        CountDownLatch countDownLatch = new CountDownLatch(count);
        SynTest synTest = new SynTest();
        Eat eat = new Eat(synTest,countDownLatch);
        Thread thread = null;
        for(int i=0;i<count;i++){
            thread = new Thread(eat);
            thread.start();
          // countDownLatch.countDown();
        }


        countDownLatch1.await();
        //Thread.sleep(1000000);
        System.out.println(synTest.i);
    }
}
class Eat implements Runnable{
    private CountDownLatch countDownLatch;
    private SynTest synTest;


    public Eat(SynTest synTest,CountDownLatch countDownLatch) {
        this.synTest = synTest;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        countDownLatch.countDown();
        try {
            for (int i = 0; i < 10; i++) {
                countDownLatch.await();
                //System.out.println(Thread.currentThread().getName()+lock.tryLock(20,TimeUnit.SECONDS));
                setSynTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        countDownLatch1.countDown();
    }

    public void setSynTest(){
        try {
            lock.lock();
            Thread.sleep(1000);
            //synchronized (Eat.class) {
            System.out.println(Thread.currentThread().getName() + "---" + synTest.i);
            synTest.i++;
           // }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}

