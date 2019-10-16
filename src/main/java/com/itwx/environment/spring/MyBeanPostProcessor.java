package com.itwx.environment.spring;

import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author:wx
 * @Date:2019/10/12 14:13
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("调用MyBeanPostProcessor构造器");
    }

    /**
     * @param bean 要处理的Bean对象
     * @param beanName bean的name属性
     * @return 要处理的Bean对象
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("调用BeanPostProcessor接口中postProcessBeforeInitialization方法[对属性进行修改]");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("调用BeanPostProcessor接口中postProcessAfterInitialization方法[对属性进行修改]");
        return bean;
    }
}
