package com.example.springmybatis.mapper;

import com.example.springmybatis.common.Page;
import com.example.springmybatis.entity.User;
import com.example.springmybatis.entity.dto.UserDto;
import com.example.springmybatis.entity.queryCondition.UserQueryCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询
    List<User> queryUser(UserQueryCondition queryCondition, Page page);

    //新增
    void createUsers(List<User> users);

    //修改
    void updateUsers(UserQueryCondition queryCondition);

    //删除
    void deleteUsers(UserQueryCondition queryCondition);

    //查询
    List<UserDto> queryUserOfClass(UserQueryCondition queryCondition, Page page);

}
