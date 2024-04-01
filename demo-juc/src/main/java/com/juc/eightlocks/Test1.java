package com.juc.eightlocks;

import java.util.concurrent.TimeUnit;

/***
 * 1、标准情况下 ，两个线程是先打印发短信还是 打电话 ？
 * 2、sendSms +4s 两个线程是先打印发短信还是 打电话 ？
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(() -> {phone.sendSms();}).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {phone.call();}).start();
    }
}
class Phone{
    //synchronired 锁的是对象是方法的调用者
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}
