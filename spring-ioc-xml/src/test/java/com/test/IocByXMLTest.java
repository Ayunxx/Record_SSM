package com.test;

import com.ssm.spring_2.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocByXMLTest {

    /**
     * 获取bean的三种方式
     *  1、根据bean的id获取
     *  2、根据bean的类型获取， 根据类型获取bean时要求IOC容器中有且只有一个类型匹配的bean
     *  3、根据bean的id和类型获取
     *
     * */

    @Test
    public void TestIoc(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        Student studentOne = (Student) ioc.getBean("studentTwo");
/*        Student student = ioc.getBean(Student.class);
        System.out.println(student);*/
        System.out.println(studentOne);
    }
}
