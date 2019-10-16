package com.itwx.environment.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @Author:wx
 * @Date:2019/10/12 13:41
 * 该类实现系列接口均为Bean级生命周期接口方法
 */
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;

    private String address;

    private String phone;

    private BeanFactory beanFactory;

    private String beanName;

    public Person() {
        System.out.println("【构造器】调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【注入属性】注入属性address");
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("【注入属性】注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    /**
     * 重写BeanFactoryAware接口中的方法
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactory.setBeanFactory()方法");
        this.beanFactory = beanFactory;
    }

    /**
     * 重写BeanNameAware接口的方法
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanNameAware()方法");
        this.name = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】 调用Disposable.destroy()方法");
    }

    /**
     * 重写InitializingBean接口方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】 调用InitializingBean.afterPropertiesSet()方法");
    }


    /**
     * 自定义初始化、销毁方法
     */
    public void myInit() {
        System.out.println("【my-init】调用<bean>的init-method属性指定的初始化方法");
    }

    public void myDestroy() {
        System.out.println("【my-destroy】调用<bean>destroy-method属性指定的初始化方法");
    }


}
