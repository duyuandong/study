package com.spring.framework.context.support;



import com.spring.framework.beans.factory.support.BeanDefinitionReader;
import com.spring.framework.beans.factory.support.BeanDefinitionRegistry;
import com.spring.framework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：duyd@segimail.com
 * @class ：org.spring.framework.context.support.AbstractApplicantionContext
 * @date ：Created in 2024/2/20 14:22
 * @description：ApplicantionContext接口的子实现类,用于立即加载
 * @modified By：
 * @version:
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    //声明解析器变量
    protected BeanDefinitionReader beanDefinitionReader;
    //定义用于存储bean对象的map容器
    protected Map<String,Object> singetonObejects = new HashMap<String,Object>();
    //声明配置文件路径的变量
    protected String configLoaction;

    @Override
    public void refresh() throws Exception {
        //加载BeanDefinition对象
        beanDefinitionReader.loadBeanDefinitions(configLoaction);
        //初始化bean
        finishBeanInitialization();
    }

    //bean的初始化
    private void finishBeanInitialization() throws Exception{
        //获取注册表对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();

        //获取BeanDefinition对象
        String[] beanNames = registry.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            //进行bean的初始化
            getBean(beanName);
        }
    }
}
