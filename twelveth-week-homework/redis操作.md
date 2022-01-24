# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/#build-image)

1.创建多个实例：
redis.windows-service.conf
redis.windows-service-6380.conf
redis.windows-service-6381.conf
2.设置为6379的从节点
6380:SLAVEOF 127.0.0.1 6379
6381:SLAVEOF 127.0.0.1 6379
3.sentinel监听6379的
6379：sentinel.conf
6380：sentinel-6380.conf
6381：sentinel-6381.conf