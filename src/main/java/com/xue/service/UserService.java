package com.xue.service;

import com.xue.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by xueqi on 2020-01-25 16:38
 */
@Service
public interface UserService {

    List<User> findAllUser();
    String findAllUser(Integer pageNumber, Integer pageSize);
    List<User> findUserByName(String name);
    User findUSerByOne(int id);

    Integer addUser(User user);
    Integer addUserList(List<User> userList);

    Integer updateUser(User user);
    Integer updateUserList(List<User> userList);

    Integer deleteUser(User user);
    Integer deleteUserList(List<Integer> ids);

}
