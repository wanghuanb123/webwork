package com.admin.dao;

import com.admin.entity.Admin;
import com.admin.entity.GType;
import com.foods.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    /*
    * 新增用户
    * */
    public void addAdmin(Admin admin, Connection connection) throws SQLException {
//        编写sql
        String sql = " insert into admin(Admin_Name,Admin_Password,Admin_Type) values(?,?,?) ";
//        预编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
//        填充占位符
        pstmt.setString(1, admin.getAdminName());
        pstmt.setString(2, admin.getAdminPassword());
        pstmt.setInt(3, admin.getAdminType().getGTypeId());
//        执行sql
        pstmt.executeUpdate();
//        关闭资源
        ConnectionUtil.closeConnection(pstmt);
    }

    /*
    * 用户账号查找用户
    * */
    public Admin findAdminByAdminName(String adminName,Connection connection) throws SQLException {
//        编写sql
        String sql = " select * from admin,gtype where admin.Admin_Type = gtype.GType_ID and Admin_Name = ? ";
//        欲编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
//        填充占位符
        pstmt.setString(1, adminName);
//        执行sql
        ResultSet rs = pstmt.executeQuery();
//        处理结果集
        Admin admin = null;
        if (rs.next()){
            admin = new Admin(rs.getInt("Admin_Id"),
                    rs.getString("Admin_Name"),
                    rs.getString("Admin_Password"),
                    new GType(rs.getInt("Admin_Type"),rs.getString("GType_Name")));
        }
//        关闭资源
        ConnectionUtil.closeConnection(pstmt, rs);
//        返回结果集
        return  admin;
    }
}
