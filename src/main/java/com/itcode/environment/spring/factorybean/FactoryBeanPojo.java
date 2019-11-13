package com.itcode.environment.spring.factorybean;

import com.itcode.environment.spring.mode.School;
import com.itcode.environment.spring.mode.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author:wx
 * @Date:2019/11/13 10:16
 */
public class FactoryBeanPojo implements FactoryBean {
    private static final String STUDENT = "student";
    private String type;
    /**
     * getBean(String beanName)方法实际上是有FactoryBean的实现类getObject()方法返回的对象
     * @return
     */
    @Override
    public Object getObject() {
        if(STUDENT.equals(type)){
            return new Student();
        }else{
            return new School();
        }

    }

    @Override
    public Class getObjectType() {
        return School.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
