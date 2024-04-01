package com.juc.lock;

/**
 * @author ：duyd@segimail.com
 * @class ：com.juc.lock.SyncSaleTicket
 * @date ：Created in 2024/4/1 14:03
 * @description：sync 买票
 * @modified By：
 * @version:
 */
public class SyncSaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();},"A").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();},"B").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();},"C").start();
    }


}
class Ticket{
    private  int ticketNum = 30;
    public synchronized  void sale(){
        if(ticketNum > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + (ticketNum--) + "张, 剩余" + ticketNum);
        }
    }
}
