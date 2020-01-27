package com.xue.mapper;

import com.xue.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends CommonMapper<User> {
    Integer updateUserByList(List<User> userList);

    @Select("select * from t_user")
    @ResultType(User.class)
    List<User> findAll();
}