package io.kimmking.rpcfx.api;

import io.kimmking.rpcfx.client.Rpcfx;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class ClientAnnotationFactoryBean<T> implements FactoryBean<T> {
    private static final String url = "http://localhost:8080/";

    private Class<T> tClass;

    public ClientAnnotationFactoryBean(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(Rpcfx.class.getClassLoader(), new Class[]{tClass}, new Rpcfx.RpcfxInvocationHandler(tClass, url, null));
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    public void settClass(Class<T> tClass) {
        this.tClass = tClass;
    }
}
