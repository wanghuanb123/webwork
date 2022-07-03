package com.user.dao;


import com.foods.entity.Foods;
import com.foods.entity.Type;
import com.foods.utils.ConnectionUtil;

import com.user.entity.UType;
import com.user.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    /*
     * 查询所有用户的方法
     * */
    public List<User> showAllUser(Connection connection) throws SQLException
    {
        // 编写sql
        String sql="select * from user,utype where user.User_Type = utype.Utype_ID ";
        // 欲编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
        // 执行sql
        ResultSet rs = pstmt.executeQuery();
        // 处理结果集合
        List<User> list = new ArrayList<>();

        while (rs.next())
        {
            User user = new User(rs.getInt("User_ID"),rs.getString("User_Name"),
                    rs.getString("User_Account")
                    ,rs.getString("User_Password"),
                    rs.getString("User_Address"),
                    rs.getString("User_Tel"),
                    new UType(rs.getInt("Utype_ID"),rs.getString("Utype_Name")));
            list.add(user);
        }
        // 关闭资源
        ConnectionUtil.closeConnection(pstmt,rs);

        return list;
    }

    /*
    * 按用户名查询用户的方法
    * */
    /*
     * 根据菜名查询菜品的方法
     * */
    public List<User> showUserByUserName(String userName, Connection connection) throws SQLException
    {
        // 编写sql
        String sql="select * from user,utype where user.User_Type = utype.UType_ID and user.User_Name = ?";
        // 欲编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //填充占位符
        pstmt.setString(1, userName);
        // 执行sql
        ResultSet rs = pstmt.executeQuery();
        // 处理结果集合
        List<User> list = new ArrayList<>();

        while (rs.next())
        {
            User user = new User(rs.getInt("User_ID"),rs.getString("User_Name"),
                    rs.getString("User_Account")
                    ,rs.getString("User_Password"),
                    rs.getString("User_Address"),
                    rs.getString("User_Tel"),
                    new UType(rs.getInt("Utype_ID"),rs.getString("Utype_Name")));
            list.add(user);
        }
        // 关闭资源
        ConnectionUtil.closeConnection(pstmt,rs);

        return list;
    }

    /*
     * 根据编号查询用户的方法
     * */
    public User findUserByUserId(int userId, Connection connection) throws SQLException
    {
        // 编写sql
        String sql="select * from user,utype where user.User_Type = utype.Utype_ID and user.User_Id = ?";
        // 欲编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //填充占位符
        pstmt.setInt(1, userId);
        // 执行sql
        ResultSet rs = pstmt.executeQuery();
        // 处理结果集合
        List<User> list = new ArrayList<>();

        User user = null;
        while (rs.next())
        {
            user = new User(rs.getInt("User_ID"),rs.getString("User_Name"),
                    rs.getString("User_Account")
                    ,rs.getString("User_Password"),
                    rs.getString("User_Address"),
                    rs.getString("User_Tel"),
                    new UType(rs.getInt("Utype_ID"),rs.getString("Utype_Name"))/*,
                    rs.getString("Menus_Img")*/);
        }
        // 关闭资源
        ConnectionUtil.closeConnection(pstmt,rs);


        return user;
    }

    /*
     * 修改用户的方法
     * */
    public void alterUserByUserID(User user, Connection conn)throws SQLException {
//        编写sql
        String sql = "update user set User_Name = ?,User_Account = ?,User_Password = ?,User_Address = ?,User_Tel = ?,User_Type = ? where User_ID = ?";
//        预编译sql
        PreparedStatement pstmt = conn.prepareStatement(sql);
//        填充占位符
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserAccount());
        pstmt.setString(3, user.getUserpassword());
        pstmt.setString(4, user.getUserAddress());
        pstmt.setString(5,user.getUserTel());
        pstmt.setInt(6, user.getUserType().getUTypeId());
        pstmt.setInt(7,user.getUserId());
//        pstmt.setString(5,menus.getMenusImg());
//        执行sql
        pstmt.executeUpdate();
//        关闭资源
        ConnectionUtil.closeConnection(pstmt);
    }

    /*
     * 删除用户的方法
     * */
    public void deleteUser(Integer userId,Connection connection) throws SQLException {
//        编写sql
        String sql = " delete from user where User_ID = ? ";
//        欲处理
        PreparedStatement pstmt = connection.prepareStatement(sql);
//        填充占位符
        pstmt.setInt(1, userId);
//        执行sql.
        pstmt.executeUpdate();
//        关闭资源
        ConnectionUtil.closeConnection(pstmt);
    }
}
