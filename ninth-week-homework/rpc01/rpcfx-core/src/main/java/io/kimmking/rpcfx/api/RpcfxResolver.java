package io.kimmking.rpcfx.api;

public interface RpcfxResolver {

    Object resolve(String serviceClass);

    Object resolve(Class serviceClass);
}
