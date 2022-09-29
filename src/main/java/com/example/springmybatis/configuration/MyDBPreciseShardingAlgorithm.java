package com.example.springmybatis.configuration;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

//@Configuration
public class MyDBPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

    /**
     *
     * @param databaseNames  所有分片库的集合
     * @param shardingValue  分片属性
     * @return
     */
    @Override
    public String doSharding(Collection<String> databaseNames, PreciseShardingValue<Integer> shardingValue) {
        System.out.println(" ======= 自定义数据库分片算法");

        for (String databaseName : databaseNames) {
            String value = shardingValue.getValue() % databaseNames.size() + "";
            if (databaseName.endsWith(value)){
                return databaseName;
            }
        }

        throw new IllegalArgumentException();
    }
}
