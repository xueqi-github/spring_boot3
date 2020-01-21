package com.xue.dao;

import com.xue.mapper.UserMapper;
import com.xue.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by xueqi on 2020-01-20 18:01
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public Integer addUser(User user){return userMapper.insert(user);}

    public  Integer addUserList(List<User> userList){
        return userMapper.insertList(userList);
    }

    public List<User> findUserByName(String name){
        Example example = new Example(User.class);
        example.createCriteria()
                .andLike("userName","%"+name+"%");
        return userMapper.selectByExample(example);
    }

    public User findUSerByOne(int id){
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id",id);
        return userMapper.selectOneByExample(example);
    }

    public Integer deleteUserList(List<Integer> ids){
        Example example = new Example(User.class);
        example.createCriteria()
                .andIn("id",ids);
        return userMapper.deleteByExample(example);
    }

    public Integer updateUserList(List<User> userList){
        return userMapper.updateUserList(userList);
    }
}
