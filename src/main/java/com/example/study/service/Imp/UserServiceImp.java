package com.example.study.service.Imp;

import com.example.study.entity.User;
import com.example.study.mapper.UserMapper;
import com.example.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserMapper userMapper;

    public User queryUserByName(String name) {
        User userInfo=userMapper.queryUserByName(name);
        return userInfo;
    }

    @Override
    public int insertUser(User user) {
        int count=userMapper.insertUser(user);
        return count;
    }
}
