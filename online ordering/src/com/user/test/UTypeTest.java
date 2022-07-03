package com.user.test;


import com.foods.utils.ConnectionUtil;
import com.user.dao.UTypeDAO;
import com.user.entity.UType;


import java.sql.Connection;
import java.util.List;

public class UTypeTest {
    public static void main(String[] args) throws Exception {
        UTypeDAO typeDAO = new UTypeDAO();
        Connection connection = ConnectionUtil.getConnection();
        List<UType> allType = typeDAO.findAllUType(connection);
        for (int i = 0; i < allType.size(); i++) {
            System.out.println(allType.get(i));
        }
        ConnectionUtil.closeConnection(connection);
    }
}

