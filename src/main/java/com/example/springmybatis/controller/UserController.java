package com.example.springmybatis.controller;

import com.example.springmybatis.common.Code;
import com.example.springmybatis.common.Page;
import com.example.springmybatis.common.ResponseResult;
import com.example.springmybatis.entity.User;
import com.example.springmybatis.entity.dto.UserDto;
import com.example.springmybatis.entity.queryCondition.UserQueryCondition;
import com.example.springmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //整合springboot后，得使用@Transactional注解才会让一级缓存生效，
    //由于SpringBoot使用HikariPC，在执行一个任务时从HikariPool中获取一个SqlSession，但是当该操作完成就commit，
    //这就导致两次查询使用的不是同一个sqlSessioin，根据一级缓存的原理，它将永远不会生效。
    //当我们开启了事务，下一次查询也在同一个sqlSession中，第二次查询就命中缓存
    @GetMapping("/info")
    @Transactional
    public ResponseResult getUserInfo(@RequestParam(required = true) Integer id) {
        //如果不是按照分片键去查询，就会把所有的数据源库都查询一遍
        //按照分片键查询，就会直接查到这个键所在的数据源
        //原理：执行sql会生成一个逻辑sql ==>  Logic SQL  基于逻辑sql再根据查询条件，查询各个数据源，将查询到的结果返回
        UserQueryCondition query = new UserQueryCondition();
        query.setId(id);
//        query.setName(name);
//        query.setAge(age);
//        query.setFromAge(5);
//        query.setToAge(10);


        Page page = new Page(0, 10);
        List<User> users = userMapper.queryUser(query, page);

        if (users == null){
            return new ResponseResult(null, Code.fail.build(),"无数据");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("result", users);

        return new ResponseResult(map, Code.success.build(),"返回成功");
    }


    @GetMapping("/add")
    @Transactional
    public ResponseResult addUser() {
        List<User> list = new LinkedList<>();

        for (int i=0; i<10; i++){
            User user = new User();
            user.setAge(i);
            user.setClassId(2);
            user.setName("张三"+ i + "号");
            user.setSex(1);
            user.setCreateTime(new Date(System.currentTimeMillis()));
            list.add(user);
        }

        userMapper.createUsers(list);

        return new ResponseResult(null, Code.success.build(),"新增成功");
    }

    @GetMapping("/info/class")
    @Transactional
    public ResponseResult getUserAndClassInfo(@RequestParam(required = true) Integer id) {
        UserQueryCondition query = new UserQueryCondition();
        query.setId(id);

        Page page = new Page(0, 10);
        List<UserDto> users = userMapper.queryUserOfClass(query, page);

        if (users == null){
            return new ResponseResult(null, Code.fail.build(),"无数据");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("result", users);

        return new ResponseResult(map, Code.success.build(),"返回成功");
    }
}
