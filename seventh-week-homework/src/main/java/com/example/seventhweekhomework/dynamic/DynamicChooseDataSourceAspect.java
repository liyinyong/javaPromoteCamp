package com.example.seventhweekhomework.dynamic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicChooseDataSourceAspect {
    @Pointcut("@annotation(com.example.seventhweekhomework.dynamic.DynamicChooseSource)")
    public void dynamicChooseDataSource() {

    }

    @Around("dynamicChooseDataSource()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ProceedingJoinPoint pjp;
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DynamicChooseSource dynamicChooseSource = method.getAnnotation(DynamicChooseSource.class);
        if (dynamicChooseSource != null) {
            DynamicDataSource.setDataSource(dynamicChooseSource.name());
        }
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }
}
