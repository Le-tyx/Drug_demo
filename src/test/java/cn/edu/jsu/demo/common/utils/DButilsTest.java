package cn.edu.jsu.demo.common.utils;


import cn.edu.jsu.demo.model.UserDemo;
import org.junit.Test;

import java.util.List;

public class DButilsTest {

    @Test
    public void getList() {

        String sql = "select id,userName,createdDt,modifiedDt from user1 where id = ?";
        List<UserDemo> userList =  DButils.getList(UserDemo.class,sql,1);

        System.out.println(userList);
    }
}
