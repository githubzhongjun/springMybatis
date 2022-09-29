package com.example.springmybatis.configuration;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;

public class MyDBRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Integer> rangeShardingValue) {
        System.out.println("范围-*-*-*-*-*-*-*-*-*-*-*---------------"+collection);
        System.out.println("范围-*-*-*-*-*-*-*-*-*-*-*---------------"+rangeShardingValue);
        Collection<String> collect = new LinkedHashSet<>();
        Range<Integer> valueRange = rangeShardingValue.getValueRange();
        for (Integer i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String each : collection) {
                if (each.endsWith(i % collection.size() + "")) {
                    collect.add(each);
                }
            }
        }
        //
        return collect;
    }
}
