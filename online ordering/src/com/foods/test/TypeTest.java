package com.foods.test;


import com.foods.dao.TypeDAO;
import com.foods.entity.Type;
import com.foods.utils.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class TypeTest {
    public static void main(String[] args) throws Exception {
        TypeDAO typeDAO = new TypeDAO();
        Connection connection = ConnectionUtil.getConnection();
        List<Type> allType = typeDAO.findAllType(connection);
        for (int i = 0; i < allType.size(); i++) {
            System.out.println(allType.get(i));
        }
        ConnectionUtil.closeConnection(connection);
    }
}
