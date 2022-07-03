package com.user.test;

import com.user.entity.User;
import com.user.service.UserService;

import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        UserService userService = new UserService();
        List<User> user = userService.selectAllUser();
        for (int i = 0; i < user.size(); i++) {
            System.out.println(user.get(i));
        }
    }
}
