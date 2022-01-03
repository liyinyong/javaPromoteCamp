package io.kimmking.rpcfx.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RpcfxRequest<T> {
  private Class<T> serviceClass;
  private String method;
  private Object[] params;

  public RpcfxRequest (Class<T> tClass) {
      this.serviceClass = tClass;
  }
}

