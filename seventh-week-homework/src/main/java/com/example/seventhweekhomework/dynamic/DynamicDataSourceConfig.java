package com.example.seventhweekhomework.dynamic;

import com.example.seventhweekhomework.config.PrimaryDataSourceConfig;
import com.example.seventhweekhomework.config.SlaveDataSourceConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Configuration
public class DynamicDataSourceConfig {
    @Bean
    @Primary
    @ConditionalOnBean({PrimaryDataSourceConfig.class, SlaveDataSourceConfig.class})
    public DynamicDataSource dynamicDataSource(DataSource primaryDataSource, DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("primary", primaryDataSource);
        targetDataSources.put("slave", slaveDataSource);
        return new DynamicDataSource(primaryDataSource, targetDataSources);
    }
}
