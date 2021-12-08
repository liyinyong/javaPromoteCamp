package com.example.localstarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "local.properties")
@Data
public class LocalProperties {
    private Integer id;
    private String name;
}
