package com.itcode.environment.spring.test;

import com.itcode.environment.spring.factorybean.FactoryBeanPojo;
import com.itcode.environment.spring.mode.School;
import com.itcode.environment.spring.mode.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:wx
 * @Date:2019/11/13 10:20
 */
public class FactoryBeanTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext pathXmlApplicationContext = new ClassPathXmlApplicationContext("BeanConfig.xml");
        Student student = (Student) pathXmlApplicationContext.getBean("student");
        System.out.println(student.getName());
        System.out.println("-----------factoryBean实现类getBean--------");
        FactoryBeanPojo factoryBeanPojo = (FactoryBeanPojo) pathXmlApplicationContext.getBean("&factoryBeanPojo");
        System.out.println(factoryBeanPojo.getClass().getName());
        System.out.println("type:-" + factoryBeanPojo.getType());
        System.out.println("------------自动装配属性值-------");
        //采用byName方式，自动装配School中的student属性值
        School school = (School) pathXmlApplicationContext.getBean("school");
        System.out.println("school:" + school.getSchoolName() + ", studentName:" + school.getStudentByType().getName());
    }
}
