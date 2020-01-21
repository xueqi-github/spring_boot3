package com.xue;

import com.xue.dao.UserDao;
import com.xue.pojo.User;
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
    @Test
    void contextLoads() {
        User user = new User("哈士奇","123123","二哈","榆林");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Integer res = userDao.addUser(user);
        System.out.println(res);
    }
    @Test
    void uesrList(){
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
    @Test
    void findUserByname(){
        List<User> res = userDao.findUserByName("哈士奇");
        System.out.println(res);
    }
    @Test
    void findUserByOne(){
        User res = userDao.findUSerByOne(9);
        System.out.println(res);
    }
    @Test
    void  deleteUserByIds(){
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ids.add(i);
        }
        Integer res = userDao.deleteUserList(ids);
        System.out.println(res);
    }

}
