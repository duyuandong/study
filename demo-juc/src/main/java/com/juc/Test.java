package com.juc;

/**
 * @author ：duyd@segimail.com
 * @class ：com.juc.Test
 * @date ：Created in 2024/4/1 11:44
 * @description：
 * @modified By：
 * @version:
 */
public class Test {
    public static void main(String[] args) {
        //cpu线程核心
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println((int)(Runtime.getRuntime().freeMemory() / 1024 / 1024) + "M");
    }
}
