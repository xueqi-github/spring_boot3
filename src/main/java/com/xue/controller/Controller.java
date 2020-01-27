package com.xue.controller;

import com.alibaba.fastjson.JSON;
import com.xue.pojo.User;
import com.xue.service.UserService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * Created by xueqi on 2020-01-16 12:37
 */
@Slf4j
@RestController
public class Controller {
//    http://localhost:8080/swagger-ui.html
    @Autowired
    private UserService userService;

/*    @GetMapping
    public String hello(@RequestParam(name = "content",required = false) String content){
        log.info("开始打印日志，内容为{}",content);
        return content;
    }*/

    //分页查询
    @GetMapping("selectByPageHelper/json")
    public String getAllUser(Integer pageNumber, Integer pageSize){
        return userService.findAllUser(pageNumber,pageSize);
    }
    //不分页查询
    @GetMapping("selectNopagehelper")
    public List<User> getAllUser(){
       return userService.findAllUser();
    }
    //模糊查询
    @GetMapping("seletUesrLike")
    public List<User> findUserByName(String name){
        return userService.findUserByName(name);
    }
    //id查询
    @GetMapping("selectUserById")
    public User findUSerByOne(int id){
        return userService.findUSerByOne(id);
    }
    //单个添加,Json方式
    @PostMapping("addUserJson/json")
    public Integer findAllUser(@RequestBody User user){
        return  userService.addUser(user);
    }
    //单个添加,表单方式
    @PostMapping("addUserForm/form")
    public Integer addUser(User user){
        return userService.addUser(user);
    }

    //批量添加，Json方式
    @PostMapping("addUserByList/users")
    public Integer findAllUser(@RequestBody List<User> userList){
        return userService.addUserList(userList);
    }
    //单独更新，Json方式
    @PostMapping("updateJson/user")
    public Integer updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    //单独更新，表单方式
    @PostMapping("updateForm/user")
    public Integer updateUser2(User user){
        return userService.updateUser(user);
    }
    //批量更新，Json方式
    @PostMapping("updateJson/users")
    public Integer updateUser(@RequestBody List<User> userList){
        return userService.updateUserList(userList);
    }
    //单独删除，Json方式
    @PostMapping("deleteJson/user")
    public Integer deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }
    //单独删除，表单方式
    @PostMapping("updateForm/user")
    public Integer deleteUser2( User user){
        return userService.deleteUser(user);
    }
    //批量删除，Json方式
    @PostMapping("update/users")
    public Integer deleteUserList(@RequestBody List<Integer> ids){
        return userService.deleteUserList(ids);
    }


}
