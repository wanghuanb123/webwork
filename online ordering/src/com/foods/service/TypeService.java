package com.foods.service;

import com.foods.dao.TypeDAO;
import com.foods.entity.Type;
import com.foods.utils.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class TypeService {

    private TypeDAO typeDAO = new TypeDAO();
/*
* 查询所有类型
* */
    public List<Type> selectAllType() {

        Connection connection = ConnectionUtil.getConnection();

        List<Type> allType = null;
        try {
            allType = typeDAO.findAllType(connection);
        } catch (Exception throwables) {

            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        ConnectionUtil.closeConnection(connection);
        return allType;
    }

}
