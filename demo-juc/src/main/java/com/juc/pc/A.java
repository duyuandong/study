package com.juc.pc;

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
public class A {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"D").start();
    }
}

class Data{
    private int num = 0;
    //+1
    public synchronized void increment() throws InterruptedException {
        while(num != 0){ //不用if用while ,if会导致虚假唤醒
            //等待
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "->" + num);
        this.notifyAll();
    }
    //-1
    public synchronized void decrement() throws InterruptedException {
        while(num == 0){//不用if用while ,if会导致虚假唤醒
            //等待
            this.wait();
        }

        num--;
        System.out.println(Thread.currentThread().getName() + "->" + num);
        this.notifyAll();
    }
}
