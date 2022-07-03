package com.admin.service;

import com.admin.dao.GTypeDAO;
import com.admin.entity.GType;
import com.foods.dao.TypeDAO;
import com.foods.entity.Type;
import com.foods.utils.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class GTypeService {

    private GTypeDAO gTypeDAO = new GTypeDAO();
    /*
     * 查询所有类型
     * */
    public List<GType> selectAllGType() {

        Connection connection = ConnectionUtil.getConnection();

        List<GType> allGType = null;
        try {
            allGType = gTypeDAO.findAllGType(connection);
        } catch (Exception throwables) {

            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        ConnectionUtil.closeConnection(connection);
        return allGType;
    }
}

