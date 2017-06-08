package com.lyc.com.lyc.threadtest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lyc on 2017/6/8.
 * 测试中断
 */
public class InterruptiblyTest {
    static int i=0;
    static Lock lock = new ReentrantLock();
    static Thread thread;
    static Thread thread1;
    public static void main(String[] args) {
        Gog gog = new Gog();
        thread = new Thread(gog);
         thread1 = new Thread(gog);
        thread.start();
        thread1.start();
        //thread.interrupt();

    }
}
class Gog implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            increment();
        }
    }

    private void increment() {

            try {
                System.out.println(Thread.currentThread().getName());
                //System.out.println(InterruptiblyTest.lock.tryLock(1,TimeUnit.SECONDS));
                InterruptiblyTest.lock.lockInterruptibly();


                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "" + InterruptiblyTest.i);
                InterruptiblyTest.i++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                InterruptiblyTest.lock.unlock();
            }

    }
}


