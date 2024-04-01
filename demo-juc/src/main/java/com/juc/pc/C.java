package com.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：duyd@segimail.com
 * @class ：com.juc.pc.C
 * @date ：Created in 2024/4/1 15:38
 * @description：
 * @modified By：
 * @version:
 */
public class C {
    public static void main(String[] args) {
        DataC dataC = new DataC();
        new Thread(()->{for (int i = 0; i < 10; i++) dataC.printA();},"A").start();
        new Thread(()->{for (int i = 0; i < 10; i++) dataC.printB();},"B").start();
        new Thread(()->{for (int i = 0; i < 10; i++) dataC.printC();},"C").start();
    }
}
class DataC{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private int num = 1; //1A、2B、3C
    public void printA(){
        lock.lock();
        try {
            //业务 、判断 、等待 、通知
            while (num != 1){
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> AAAAAAAAAA");
            num = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            //业务 、判断 、等待 、通知
            while (num != 2){
                //等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> BBBBBBBBB");
            num = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            //业务 、判断 、等待 、通知
            while (num != 3){
                //等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> CCCCCCCCC");
            num = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
