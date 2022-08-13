package com.ssm.spring_3.aop.annotation.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect  //将当前组件标识为一个切面
public class LoggerAspect {
    /**
     * 在切面中，需要通过指定注解将方法标识为通知方法
     * 切入点表达式：设置在标识通知的注解的value属性中
     *
     * 重用切入点表达式
     * @Pointcut   声明一个公共的切入点表达式
     *
     *
     * 获取连接点的信息
     * 设置joinPoint类型的参数
     *
     * */

    @Pointcut("execution(* com.ssm.spring_3.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){

    }


    //@Before("execution(public int com.ssm.spring_3.aop.annotation.CalculatorImpl.add(int,int))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，方法："+signature.getName()+"，参数："+ Arrays.toString(args));
    }


    //返回通知，在目标方法返回值之后执行,若需要返回值则需要设置returning属性
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+"，结果："+result);
    }


    //After注解 后置通知是在finally子句中执行的
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+"，执行完毕");
    }


    //异常通知 throwing属性可获取异常
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+"，异常："+ ex);
    }

    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        //表示目标对象方法的执行
        Object result =null;
        try {
            System.out.println("环绕通知--->前置通知");
            result = joinPoint.proceed();
            System.out.println("环绕通知--->返回通知");

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知--->异常通知");

        } finally {
            System.out.println("环绕通知--->后置通知");
        }
        return result;
    }

}
