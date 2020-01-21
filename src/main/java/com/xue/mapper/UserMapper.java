package com.xue.mapper;

import com.xue.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends CommonMapper<User> {
    Integer updateUserList(List<User> userList);
}