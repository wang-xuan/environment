package com.itcode.environment;

import com.itcode.environment.spring.mode.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class EnvironmentApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EnvironmentApplication.class, args);
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("BeanConfig.xml"));
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("BeanConfig.xml");
        Student student = (Student) applicationContext.getBean("student");
        String name = student.getName();
        System.out.println(name);
    }

}

