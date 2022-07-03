package com.user.test;

import com.foods.dao.FoodsDAO;
import com.foods.entity.Foods;
import com.foods.entity.Type;
import com.foods.utils.ConnectionUtil;
import com.user.dao.UserDAO;
import com.user.entity.UType;
import com.user.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public class AlterTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        User user = new User(1,"zhangsan","12121212","12121212","11","110",new UType(3,null));
        UserDAO userDAO = new UserDAO();
        userDAO.alterUserByUserID(user,connection);

        ConnectionUtil.closeConnection(connection);
    }
}
