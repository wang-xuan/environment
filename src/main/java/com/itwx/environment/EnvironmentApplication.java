package com.itwx.environment;

import com.itwx.environment.template.OrderServiceAspect;
import com.itwx.environment.template.OrderServiceProgramme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class EnvironmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnvironmentApplication.class, args);
        //读取xml文件注册bean对象
//        ApplicationContext context = new ClassPathXmlApplicationContext("programmeBean.xml");
//        OrderServiceProgramme orderService = (OrderServiceProgramme) context.getBean("orderServiceProgramme");
//        orderService.accountMoney();
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectJBean.xml");
        OrderServiceAspect orderServiceAspect = (OrderServiceAspect) context.getBean("orderServiceAspect");
        orderServiceAspect.accountMoney();
    }

}

