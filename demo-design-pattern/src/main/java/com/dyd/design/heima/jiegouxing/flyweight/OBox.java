package com.dyd.design.heima.jiegouxing.flyweight;

/**
 * @author ：duyd@segimail.com
 * @class ：com.spring.demo.com.dyd.flyweight.jiegouxing.heima.design.IBox
 * @date ：Created in 2024/1/22 11:00
 * @description：O图形 (具体享元角色)
 * @modified By：
 * @version:
 */
public class OBox extends AbstractBox{
    @Override
    public String getShape() {
        return "O";
    }
}
