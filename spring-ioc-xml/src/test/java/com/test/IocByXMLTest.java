package com.test;

import com.ssm.spring_2.controller.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocByXMLTest {


    @Test
    public void TestIoc(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        StudentController studentController = ioc.getBean(StudentController.class);
        studentController.saveStudent();
    }
}
