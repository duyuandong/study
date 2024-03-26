package com.spring.framework.beans;

/**
 * @author ：duyd@segimail.com
 * @class ：org.spring.framework.beans.BeanDefinition
 * @date ：Created in 2024/2/20 11:26
 * @description：用来封装bean标签数据
 *          id属性
 *          class属性
 *          property子标签数据
 * @modified By：
 * @version:
 */
public class BeanDefinition {
    private String id;
    private String className;
    private MutablePropertyValues propertyValues;

    public BeanDefinition() {
        propertyValues = new MutablePropertyValues();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MutablePropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
