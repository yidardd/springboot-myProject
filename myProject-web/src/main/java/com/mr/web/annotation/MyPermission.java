package com.mr.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyPermission {

    /**
     * 角色枚举
     * @author stack
     *
     */
    public enum Role{ A,B};

    Role needRole() default Role.A;

}
