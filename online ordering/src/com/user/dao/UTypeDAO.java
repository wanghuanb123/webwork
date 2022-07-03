package com.user.dao;


import com.foods.utils.ConnectionUtil;
import com.user.entity.UType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UTypeDAO {

    /*
     * 查询所有类型
     * */
    public List<UType> findAllUType(Connection conn) throws Exception {
// 1.创建集合用于存储type对象
        List<UType> list = new ArrayList<>();
// 2.编写sql
        String sql = "select * from utype";
// 3.预编译sql，获得PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
// 4.执行sql，获得结果集
        ResultSet rs = pstmt.executeQuery();
// 5.处理结果集
        while (rs.next()) {
            UType utype = new UType(rs.getInt("UType_ID"),
                    rs.getString("UType_Name"));
            list.add(utype);
        }
// 6.关闭资源
        ConnectionUtil.closeConnection(pstmt, rs);
// 7.返回集合
        return list;
    }
}
