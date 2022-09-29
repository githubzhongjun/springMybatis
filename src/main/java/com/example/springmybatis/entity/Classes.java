package com.example.springmybatis.entity;

import java.sql.Date;

public class Classes {
    private Integer id;

    private String className;

    private String classLeader;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassLeader() {
        return classLeader;
    }

    public void setClassLeader(String classLeader) {
        this.classLeader = classLeader;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", classLeader='" + classLeader + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
