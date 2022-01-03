package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.api.RpcfxResolver;
import io.kimmking.rpcfx.util.ClassUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

@Slf4j
public class DemoResolver implements RpcfxResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object resolve(String serviceClass) {
        return this.applicationContext.getBean(serviceClass);
    }

    @Override
    public Object resolve(Class serviceClass) {
        try {
            if (!serviceClass.isInterface() ) {
                Object o = serviceClass.newInstance();
                return o;
            }
            List<Class> objectList = ClassUtils.getAllClassByInterface(serviceClass);
            return objectList.get(0).newInstance();
        } catch (Exception e) {
            log.error("出错", e);
            throw new RuntimeException("无法创建实例");
        }
    }
}
