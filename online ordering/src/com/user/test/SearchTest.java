package com.user.test;

import com.foods.utils.ConnectionUtil;
import com.user.dao.UserDAO;
import com.user.entity.User;
import com.user.service.UserService;

import java.sql.Connection;
import java.util.List;

public class SearchTest {
    public static void main(String[] args) {
        UserService userService = new UserService();
//        UserDAO userDAO = new UserDAO();
//        Connection connection = ConnectionUtil.getConnection();
//        userDAO.showUserByUserName("li")
        List<User> userList = userService.selectUserByUserName("李四");

        for (int i=0;i<userList.size();i++){
            System.out.println(userList.get(i));
        }
    }
}
