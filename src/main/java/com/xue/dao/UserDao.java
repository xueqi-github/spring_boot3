package com.xue.dao;

import com.xue.mapper.UserMapper;
import com.xue.pojo.User;
import io.swagger.models.auth.In;
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
    //查询
    public List<User> findAllUser(){
        return userMapper.selectAll();
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

    //添加
    public Integer addUser(User user){return userMapper.insert(user);}

    public  Integer addUserList(List<User> userList){
        return userMapper.insertList(userList);
    }

    //删除
    public Integer deleteUser(User user){
        return userMapper.deleteByPrimaryKey(user);
    }

    public Integer deleteUserList(List<Integer> ids){
        Example example = new Example(User.class);
        example.createCriteria()
                .andIn("id",ids);
        return userMapper.deleteByExample(example);
    }

    //更新
    public Integer updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public Integer updateUserList(List<User> userList){
        return userMapper.updateUserByList(userList);
    }

}
