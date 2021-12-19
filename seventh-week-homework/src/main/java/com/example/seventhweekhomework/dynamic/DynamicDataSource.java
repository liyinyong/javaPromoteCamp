package com.example.seventhweekhomework.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal<>() ;

    public DynamicDataSource(DataSource defaultDataSource, Map<Object, Object> targetDataSources) {
        setDefaultTargetDataSource(defaultDataSource);
        setTargetDataSources(targetDataSources);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceHolder.get();
    }

    public static void setDataSource(String dataSourceName) {
        dataSourceHolder.set(dataSourceName);
    }

    public static void clearDataSource() {
        dataSourceHolder.remove();
    }
}
