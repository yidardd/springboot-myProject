package com.mr.web.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class MyPermissionAspect {

    @Pointcut("@annotation(com.mr.web.annotation.MyPermission)")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        Method method = joinPoint.getClass().getMethod(methodName, parameterTypes);
        MyPermission myPermission = method.getAnnotation(MyPermission.class);
        MyPermission.Role methodPer = myPermission.needRole();
        System.err.println("请求的方法上面的注解:" + methodPer);
        if (methodPer != null) {


        }

        MyPermission annotation = joinPoint.getClass().getAnnotation(MyPermission.class);
        MyPermission.Role classPer = annotation.needRole();
        System.err.println("请求的类上面的注解:" + classPer);

        if (classPer != null) {


        }

    }

}