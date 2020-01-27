package com.xue;

import com.xue.dao.UserDao;
import com.xue.mapper.UserMapper;
import com.xue.pojo.User;
import com.xue.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    //查询
    @Test
    void selectAll(){
        List<User> res = userMapper.findAll();
        System.out.println(res);
    }
    @Test
    void selectByPagehelper(){
        String allUser = userService.findAllUser(0, 10);
        System.out.println(allUser);
    }
    @Test
    void selectUserByname(){
        List<User> res = userDao.findUserByName("哈士奇");
        System.out.println(res);
    }
    @Test
    void selectUserByOne(){
        User res = userDao.findUSerByOne(9);
        System.out.println(res);
    }

    //添加
    @Test
    void addUser() {
        User user = new User("哈士奇","123123","二哈","榆林");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Integer res = userDao.addUser(user);
        System.out.println(res);
    }
    @Test
    void addUesrList(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User("哈士奇"+i,"10011","二哈","汉中");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userList.add(user);
        }
        Integer res = userDao.addUserList(userList);
        System.out.println(res);
    }

    //删除
    @Test
    void  deleteUserByIds(){
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ids.add(i);
        }
        Integer res = userDao.deleteUserList(ids);
        System.out.println(res);
    }
    @Test
    void delereUser() {
        User user = new User(20, "哈士奇", "123123", "二哈", "榆林", new Date(), new Date());
        Integer res = userService.deleteUser(user);
        System.out.println(res);
    }

    //更新
    @Test
    void updateUserByList(){
        List<User> userList = new ArrayList<>();
        for (int i = 30; i < 40; i++) {
            User user = new User();
            user.setId(i);
            userList.add(user);
        }
        Integer res = userDao.updateUserList(userList);
        System.out.println(res);
    }
    @Test
    void updateUser(){
        User user = new User(20,"哈士奇","123123","二哈","榆林",new Date(),new Date());
        Integer res = userService.updateUser(user);
        System.out.println(res);

    }


}
