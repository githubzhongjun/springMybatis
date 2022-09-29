package com.example.springmybatis.controller;

import com.example.springmybatis.common.Code;
import com.example.springmybatis.common.Page;
import com.example.springmybatis.common.ResponseResult;
import com.example.springmybatis.entity.Classes;
import com.example.springmybatis.entity.User;
import com.example.springmybatis.entity.queryCondition.ClassesQueryCondition;
import com.example.springmybatis.entity.queryCondition.UserQueryCondition;
import com.example.springmybatis.mapper.ClassesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class ClassesController {

    @Autowired
    private ClassesMapper classesMapper;

    @GetMapping("/class/info")
    @Transactional
    public ResponseResult getclassInfo(@RequestParam(required = true) Integer id) {
        ClassesQueryCondition query = new ClassesQueryCondition();
        query.setId(id);

        Page page = new Page(0, 10);
        List<Classes> classes = classesMapper.queryClasses(query, page);

        if (classes == null){
            return new ResponseResult(null, Code.fail.build(),"无数据");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("result", classes);

        return new ResponseResult(map, Code.success.build(),"返回成功");
    }

    @GetMapping("class/add")
    @Transactional
    public ResponseResult addClass() {
        List<Classes> list = new LinkedList<>();

        for (int i=0; i<10; i++){
            Classes classes = new Classes();
            classes.setClassLeader("王老师"+i+"号");
            classes.setClassName("地表最强"+i+"班");
            classes.setCreateTime(new Date(System.currentTimeMillis()));
            list.add(classes);
        }

        classesMapper.createClasses(list);

        return new ResponseResult(null, Code.success.build(),"新增成功");
    }

}
