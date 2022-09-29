package com.example.springmybatis.mapper;

import com.example.springmybatis.common.Page;
import com.example.springmybatis.entity.Classes;
import com.example.springmybatis.entity.queryCondition.ClassesQueryCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassesMapper {

    //查询
    List<Classes> queryClasses(ClassesQueryCondition queryCondition, Page page);

    //新增
    void createClasses(List<Classes> classes);

    //修改
    void updateClasses(ClassesQueryCondition queryCondition);

    //删除
    void deleteClasses(ClassesQueryCondition queryCondition);
}
