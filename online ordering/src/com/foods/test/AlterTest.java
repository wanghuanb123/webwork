package com.foods.test;

import com.foods.dao.FoodsDAO;
import com.foods.entity.Foods;
import com.foods.entity.Type;
import com.foods.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class AlterTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        Foods foods = new Foods(17,"番茄鸡蛋",12.2,"还行一般",new Type(6,null));
        FoodsDAO foodsDAO = new FoodsDAO();
        foodsDAO.alterFoodsByFoodsID(foods,connection);
        ConnectionUtil.closeConnection(connection);
    }
}
