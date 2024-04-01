package com.juc.eightlocks;

import java.util.concurrent.TimeUnit;

/***
 *5、增加两个静态的同步方法 只有一个对象 是先打印发短信还是打电话？
 *6.、两个对象 两个静态同步方法 是先打印发短信还是打电话？
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        //一个对象一把锁
        //两个对象的class类模板只有一个,static 锁的就是class
        Phone3 phone = new Phone3();
        Phone3 phone3 = new Phone3();
        new Thread(() -> {phone.sendSms();}).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {phone3.call();}).start();
    }

}
class Phone3{
    //synchronired 锁的是对象是方法的调用者
    //static 修饰的方法
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }
}
