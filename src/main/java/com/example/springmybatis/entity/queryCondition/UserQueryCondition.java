package com.example.springmybatis.entity.queryCondition;

import com.example.springmybatis.entity.User;

public class UserQueryCondition extends User {
    private Integer fromAge;

    private Integer toAge;

    public Integer getFromAge() {
        return fromAge;
    }

    public void setFromAge(Integer fromAge) {
        this.fromAge = fromAge;
    }

    public Integer getToAge() {
        return toAge;
    }

    public void setToAge(Integer toAge) {
        this.toAge = toAge;
    }

}
