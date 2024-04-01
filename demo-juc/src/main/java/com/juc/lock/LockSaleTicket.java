package com.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：duyd@segimail.com
 * @class ：com.juc.lock.SyncSaleTicket
 * @date ：Created in 2024/4/1 14:03
 * @description：sync 买票
 * @modified By：
 * @version:
 */
public class LockSaleTicket {

    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket2.sale();},"A").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket2.sale();},"B").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket2.sale();},"C").start();
    }


}

// 1.new ReentrantLock()
// 2.lock.lock();//加锁
// 3. finally -> lock.unlock();//解锁
class Ticket2{
    private int ticketNum = 30;
    public void sale(){
        //构造中 参数true代表[公平锁],false代表[非公平锁(默认)] , 非公平锁可以插队效率高
        ReentrantLock lock = new ReentrantLock();
        lock.lock();//加锁
//        lock.tryLock();//尝试获取锁
        try {
            //业务代码
            if(ticketNum > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (ticketNum--) + "张, 剩余" + ticketNum);
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            lock.unlock();//解锁
        }
    }
}
