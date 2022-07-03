package com.foods.dao;

import com.foods.entity.Foods;
import com.foods.entity.Type;
import com.foods.utils.ConnectionUtil;
import com.foods.utils.SqlConnectionUtil;
import com.foods.vo.SearchVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodsDAO {
    /*
    * 保存菜品的方法
    * */
    public void addMenus(Foods foods, Connection conn)throws SQLException {
//        编写sql
        String sql = " insert into foods(Foods_Name,Foods_Price,Foods_Info,Foods_type) values(?,?,?,?)";
//        预编译sql
        PreparedStatement pstmt = conn.prepareStatement(sql);
//        填充占位符
        pstmt.setString(1, foods.getFoodsName());
        pstmt.setDouble(2, foods.getFoodsPrice());
        pstmt.setString(3, foods.getFoodsInfo());
        pstmt.setInt(4, foods.getFoodsType().getTypeId());
//        pstmt.setString(5,menus.getMenusImg());
//        执行sql
        pstmt.executeUpdate();
//        关闭资源
        ConnectionUtil.closeConnection(pstmt);
    }

    /*
    * 根据菜品名称查询商品的方法
    * */
    public Foods findFoodsByFoodsName(String foodsName, Connection connection) throws SQLException {
//        1.编写sql
        String sql = " select * from foods,type where foods.Foods_Type=type.Type_ID and foods.Foods_Name = ?";
//        2.预编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
//        3.填充占位符
        pstmt.setString(1, foodsName);
//        4.执行sql
        ResultSet rs = pstmt.executeQuery();
//        5.处理结果集
        Foods foods = null;
        if (rs.next()){
            foods = new Foods(rs.getInt("Foods_ID"),rs.getString("Foods_Name"),
                    rs.getDouble("Foods_Price"),rs.getString("Foods_Info"),
                    new Type(rs.getInt("Type_ID"),rs.getString("Type_Name"))/*,
                    rs.getString("Menus_Img")*/);
        }
//        6.关闭资源
        ConnectionUtil.closeConnection(pstmt, rs);
//        7.返回
        return foods;
    }

    /*
    * 查询所有菜品的方法
    * */
    public List<Foods> showMenus(Connection connection) throws SQLException
    {
        // 编写sql
        String sql="select * from foods,type where foods.Foods_type = type.Type_ID ";
        // 欲编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
        // 执行sql
        ResultSet rs = pstmt.executeQuery();
        // 处理结果集合
        List<Foods> list = new ArrayList<>();

        while (rs.next())
        {
            Foods foods = new Foods(rs.getInt("Foods_ID"),rs.getString("Foods_Name"),
                    rs.getDouble("Foods_Price"),rs.getString("Foods_Info"),
                    new Type(rs.getInt("Type_ID"),rs.getString("Type_Name"))/*,
                    rs.getString("Menus_Img")*/);
            list.add(foods);
        }
        // 关闭资源
        ConnectionUtil.closeConnection(pstmt,rs);

        return list;
    }

    /*
     * 根据菜名查询菜品的方法
     * */
    public List<Foods> showFoosByFoodsName(String foodsName,Connection connection) throws SQLException
    {
        // 编写sql
        String sql="select * from foods,type where foods.Foods_Type = type.Type_ID and foods.Foods_Name = ?";
        // 欲编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //填充占位符
        pstmt.setString(1, foodsName);
        // 执行sql
        ResultSet rs = pstmt.executeQuery();
        // 处理结果集合
        List<Foods> list = new ArrayList<>();

        while (rs.next())
        {
            Foods foods = new Foods(rs.getInt("Foods_ID"),rs.getString("Foods_Name"),
                    rs.getDouble("Foods_Price"),rs.getString("Foods_Info"),
                    new Type(rs.getInt("Type_ID"),rs.getString("Type_Name"))/*,
                    rs.getString("Menus_Img")*/);
            list.add(foods);
        }
        // 关闭资源
        ConnectionUtil.closeConnection(pstmt,rs);

        return list;
    }

    /*
     * 根据菜品类型查询菜品的方法
     * */
    public List<Foods> showFoosByTypeId(int typeId,Connection connection) throws SQLException
    {
        // 编写sql
        String sql="select * from foods,type where foods.Foods_Type = type.Type_ID and type.Type_ID = ?";
        // 欲编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //填充占位符
        pstmt.setInt(1, typeId);
        // 执行sql
        ResultSet rs = pstmt.executeQuery();
        // 处理结果集合
        List<Foods> list = new ArrayList<>();

        while (rs.next())
        {
            Foods foods = new Foods(rs.getInt("Foods_ID"),rs.getString("Foods_Name"),
                    rs.getDouble("Foods_Price"),rs.getString("Foods_Info"),
                    new Type(rs.getInt("Type_ID"),rs.getString("Type_Name"))/*,
                    rs.getString("Menus_Img")*/);
            list.add(foods);
        }
        // 关闭资源
        ConnectionUtil.closeConnection(pstmt,rs);

        return list;
    }

    /*
     * 根据菜号查询菜品的方法
     * */
    public Foods findFoosByFoodsId(int foodsId,Connection connection) throws SQLException
    {
        // 编写sql
        String sql="select * from foods,type where foods.Foods_Type = type.Type_ID and foods.Foods_Id = ?";
        // 欲编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //填充占位符
        pstmt.setInt(1, foodsId);
        // 执行sql
        ResultSet rs = pstmt.executeQuery();
        // 处理结果集合
        List<Foods> list = new ArrayList<>();

        Foods foods = null;
        while (rs.next())
        {
            foods = new Foods(rs.getInt("Foods_ID"),rs.getString("Foods_Name"),
                    rs.getDouble("Foods_Price"),rs.getString("Foods_Info"),
                    new Type(rs.getInt("Type_ID"),rs.getString("Type_Name"))/*,
                    rs.getString("Menus_Img")*/);

        }
        // 关闭资源
        ConnectionUtil.closeConnection(pstmt,rs);

        return foods;
    }

    /*
     * 修改菜品的方法
     * */
    public void alterFoodsByFoodsID(Foods foods, Connection conn)throws SQLException {
//        编写sql
        String sql = "update foods set Foods_Name = ?,Foods_Price = ?,Foods_Info = ?,Foods_Type = ? where Foods_ID = ?";
//        预编译sql
        PreparedStatement pstmt = conn.prepareStatement(sql);
//        填充占位符
        pstmt.setString(1, foods.getFoodsName());
        pstmt.setDouble(2, foods.getFoodsPrice());
        pstmt.setString(3, foods.getFoodsInfo());
        pstmt.setInt(4, foods.getFoodsType().getTypeId());
        pstmt.setInt(5,foods.getFoodsId());
//        pstmt.setString(5,menus.getMenusImg());
//        执行sql
        pstmt.executeUpdate();
//        关闭资源
        ConnectionUtil.closeConnection(pstmt);
    }

    /*
    * 多条件查询菜品的方法
    * */
    public List<Foods> showFoosBySearchVO(SearchVo searchVo, Connection connection) throws SQLException
    {
        // 编写sql
        String sql="select * from foods,type where foods.Foods_Type = type.Type_ID "
                + SqlConnectionUtil.searchWhere(searchVo);
        // 欲编译sql
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //填充占位符
        // 执行sql
        ResultSet rs = pstmt.executeQuery();
        // 处理结果集合
        List<Foods> list = new ArrayList<>();

        while (rs.next())
        {
            Foods foods = new Foods(rs.getInt("Foods_ID"),rs.getString("Foods_Name"),
                    rs.getDouble("Foods_Price"),rs.getString("Foods_Info"),
                    new Type(rs.getInt("Type_ID"),rs.getString("Type_Name"))/*,
                    rs.getString("Menus_Img")*/);
            list.add(foods);
        }
        // 关闭资源
        ConnectionUtil.closeConnection(pstmt,rs);

        return list;
    }

    /*
    * 删除菜品的方法
    * */
    public void deleteFood(Integer foodsId,Connection connection) throws SQLException {
//        编写sql
        String sql = " delete from foods where Foods_ID = ? ";
//        欲处理
        PreparedStatement pstmt = connection.prepareStatement(sql);
//        填充占位符
        pstmt.setInt(1, foodsId);
//        执行sql.
        pstmt.executeUpdate();
//        关闭资源
        ConnectionUtil.closeConnection(pstmt);
    }
}
