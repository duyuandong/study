package com.juc.eightlocks;

import java.util.concurrent.TimeUnit;

/***
 *7、1个静态的同步方法,1个普通的同步方法,只有一个对象 是先打印发短信还是打电话？
 *8、1个静态的同步方法,1个普通的同步方法,两个对象 是先打印发短信还是打电话？
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        //两个对象的class类模板只有一个,static 锁的就是class
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();
        new Thread(() -> {phone.sendSms();}).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {phone2.call();}).start();
    }

}
class Phone4{
    //synchronired 锁的是对象是方法的调用者
    //static 修饰的方法  锁的是class类模版
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("发短信");
    }

    //锁的是对象
    public synchronized void call(){
        System.out.println("打电话");
    }
}
