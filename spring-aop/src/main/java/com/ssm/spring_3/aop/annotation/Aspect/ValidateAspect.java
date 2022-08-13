package com.ssm.spring_3.aop.annotation.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) //优先级注解  值越小 优先级越高
public class ValidateAspect {

    @Before("com.ssm.spring_3.aop.annotation.Aspect.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect,前置通知");
    }

}
