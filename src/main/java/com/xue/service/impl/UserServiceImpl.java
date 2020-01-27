package com.xue.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.xue.dao.UserDao;
import com.xue.pojo.User;
import com.xue.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xueqi on 2020-01-25 16:41
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Integer addUserList(List<User> userList) {
        return userDao.addUserList(userList);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public String findAllUser(Integer pageNumber, Integer pageSize ) {
        PageHelper.offsetPage(pageNumber, pageSize);
        List<User> allUser = userDao.findAllUser();
       return JSON.toJSONString(allUser);

    }

    @Override
    public List<User> findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public User findUSerByOne(int id) {
        return userDao.findUSerByOne(id);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Integer updateUserList(List<User> userList) {
        return userDao.updateUserList(userList);
    }

    @Override
    public Integer deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public Integer deleteUserList(List<Integer> ids) {
        return userDao.deleteUserList(ids);
    }
}
