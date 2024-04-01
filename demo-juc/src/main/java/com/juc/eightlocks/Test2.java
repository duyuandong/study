package com.juc.eightlocks;

import java.util.concurrent.TimeUnit;

/***
 *1、标准情况下 ，两个线程是先打印发短信还是 打hello ？
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        //一个对象一把锁
        Phone2 phone = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(() -> {phone.sendSms();}).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {phone2.call();}).start();

        new Thread(() -> {phone.hello();}).start();
    }

}
class Phone2{
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

    public void hello(){
        System.out.println("hello");
    }
}
