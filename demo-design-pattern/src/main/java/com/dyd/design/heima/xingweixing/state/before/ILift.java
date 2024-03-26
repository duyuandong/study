package com.dyd.design.heima.xingweixing.state.before;

/**
 * @author ：duyd@segimail.com
 * @class ：com.spring.demo.com.dyd.before.state.xingweixing.heima.design.ILift
 * @date ：Created in 2024/1/23 10:05
 * @description：
 * @modified By：
 * @version:
 */
public interface ILift {
    //定义四个电梯状态常量
    int OPENING_STATE = 1;
    int CLOSING_STATE = 2;
    int RUNNING_STATE = 3;
    int STOPPING_STATE = 4;

    //设置电梯状态的功能
    void setState(int state);

    //电梯操作功能
    void open();
    void close();
    void stop();
    void run();
}
