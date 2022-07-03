package com.admin.dao;

import com.admin.entity.GType;
import com.foods.entity.Type;
import com.foods.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GTypeDAO {
    /*
     * 查询所有类型
     * */
    public List<GType> findAllGType(Connection conn) throws Exception {

        List<GType> list = new ArrayList<>();

        String sql = "select * from gtype";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            GType gType = new GType(rs.getInt("GType_ID"),
                    rs.getString("GType_Name"));
            list.add(gType);
        }

        ConnectionUtil.closeConnection(pstmt, rs);

        return list;
    }
}
