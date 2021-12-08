package com.example.localstarter.config;

import com.example.localstarter.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LocalProperties.class)
@ConditionalOnClass(LocalProperties.class)
public class LocalStarterConfiguration {

    @Autowired
    private LocalProperties localProperties;

    @Bean
    public Student autoConfigurationStudent() {
        return new Student(localProperties.getId(), localProperties.getName());
    }
}
