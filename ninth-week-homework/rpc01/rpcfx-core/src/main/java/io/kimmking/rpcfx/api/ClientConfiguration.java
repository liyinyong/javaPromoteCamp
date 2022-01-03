package io.kimmking.rpcfx.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ClientBeanRegistrar.class)
public class ClientConfiguration {
}
