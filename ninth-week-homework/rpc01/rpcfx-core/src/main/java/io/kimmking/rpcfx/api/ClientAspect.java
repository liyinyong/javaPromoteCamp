package io.kimmking.rpcfx.api;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Slf4j
@Configuration
public class ClientAspect {
    // 拦截注解
    @Pointcut("@annotation(io.kimmking.rpcfx.api.Client)")
    public void ClientAspect() {
    }

    @Around(value = "ClientAspect() && @annotation(annotation)")
    public Object createProxy(ProceedingJoinPoint thisJoinPoint, Client annotation) throws Throwable{
        log.info("method:{}", thisJoinPoint.getSignature().getName());
        return thisJoinPoint.proceed();
    }
}
