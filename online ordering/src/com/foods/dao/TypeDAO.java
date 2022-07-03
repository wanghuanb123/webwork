package com.foods.dao;

import com.foods.entity.Type;
import com.foods.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO {
/*
* 查询所有类型
* */
    public List<Type> findAllType(Connection conn) throws Exception {
// 1.创建集合用于存储type对象
        List<Type> list = new ArrayList<>();
// 2.编写sql
        String sql = "select * from type";
// 3.预编译sql，获得PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
// 4.执行sql，获得结果集
        ResultSet rs = pstmt.executeQuery();
// 5.处理结果集
        while (rs.next()) {
            Type type = new Type(rs.getInt("Type_ID"),
                    rs.getString("Type_Name"));
            list.add(type);
        }
// 6.关闭资源
        ConnectionUtil.closeConnection(pstmt, rs);
// 7.返回集合
        return list;
    }
}
