package com.example.study.mapper;

import com.example.study.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User queryUserByName(@Param("name")String name);

    public int insertUser(User user);
}
