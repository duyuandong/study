package com.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：duyd@segimail.com
 * @class ：com.juc.pc.A
 * @date ：Created in 2024/4/1 14:33
 * @description： 线程之间的通信问题 生产者和消费者问题 等待唤醒 ,等待 通知
 * 线程 A B 操作同一个变量num =0
 * A num+1
 * B num-1
 * @modified By：
 * @version:
 */
public class B {
    public static void main(String[] args) {
        DataB data = new DataB();
        new Thread(()->{for (int i = 0; i < 10; i++)data.increment();},"A").start();
        new Thread(()->{for (int i = 0; i < 10; i++)data.decrement();},"B").start();
        new Thread(()->{for (int i = 0; i < 10; i++)data.increment();},"C").start();
        new Thread(()->{for (int i = 0; i < 10; i++)data.decrement();},"D").start();
    }
}

class DataB{
    private int num = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //+1
    public void increment() {
        lock.lock();
        try {
            while(num != 0){ //不用if用while ,if会导致虚假唤醒
                //等待
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "->" + num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    //-1
    public void decrement() {
        lock.lock();
        try {
            while(num == 0){//不用if用while ,if会导致虚假唤醒
                //等待
                condition.await();
            }

            num--;
            System.out.println(Thread.currentThread().getName() + "->" + num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
