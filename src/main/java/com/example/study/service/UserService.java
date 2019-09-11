package com.example.study.service;

import com.example.study.entity.User;

public interface UserService {
    /**根据用户名查询用户信息
     *
     * @param name
     * @return
     */
    public User queryUserByName(String name);

    /**注册用户信息
     *
     * @param user
     * @return
     */
    public int insertUser(User user);
}
