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

        Object target = joinPoint.getTarget();
        String methodName = joinPoint.getSignature().getName();
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        Method method = target.getClass().getMethod(methodName, parameterTypes);
        MyPermission methodAnnotation = method.getAnnotation(MyPermission.class);
        if (methodAnnotation != null) {
            MyPermission.Role methodPer = methodAnnotation.needRole();
            System.err.println("请求的方法上面的注解:" + methodPer);

            //从session或者缓存中取出用户的角色信息,进行对比,,如果不符合返回权限不足

        }


        MyPermission classAnnotation = target.getClass().getAnnotation(MyPermission.class);
        if (classAnnotation != null) {
            MyPermission.Role classPer = classAnnotation.needRole();
            System.err.println("请求的类上面的注解:" + classPer);

            //从session或者缓存中取出用户的角色信息,进行对比,,如果不符合返回权限不足


        }


    }

}