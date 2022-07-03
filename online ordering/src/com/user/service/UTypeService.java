package com.user.service;


import com.foods.utils.ConnectionUtil;
import com.user.dao.UTypeDAO;
import com.user.entity.UType;


import java.sql.Connection;
import java.util.List;

public class UTypeService {
    private UTypeDAO uTypeDAO = new UTypeDAO();
    /*
     * 查询所有类型
     * */
    public List<UType> selectAllType() {

        Connection connection = ConnectionUtil.getConnection();

        List<UType> allUType = null;
        try {
             allUType = uTypeDAO.findAllUType(connection);
        } catch (Exception throwables) {

            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        ConnectionUtil.closeConnection(connection);
        return allUType;
    }
}
