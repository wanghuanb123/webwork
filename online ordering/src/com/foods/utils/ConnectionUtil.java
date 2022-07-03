package com.foods.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
//    创建一个连接池（数据源）对象
    private  static  DataSource ds ;

    static {
        //        1.读取配置文件
        InputStream inputStream = com.foods.utils.ConnectionUtil.class.getResourceAsStream("/mysql.properties");

        Properties ps = new Properties();
        try {
            //        加载流
            ps.load(inputStream);
//            根据配置文件中的信息 利用Druid 获得数据源==连接池
            ds= DruidDataSourceFactory.createDataSource(ps);
        } catch (Exception e) {
            System.out.println("创建连接池失败！");
            e.printStackTrace();
        }
    }

//    获取连接得方法
    public static Connection getConnection(){
        Connection conn = threadLocal.get();
        if (conn==null){
            try {
//                获取连接池中的对象
                conn=ds.getConnection();
                threadLocal.set(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }


    //    关闭连接的方法
    public static void closeConnection(PreparedStatement pstmt){
        try {
            if (pstmt!=null){
                pstmt.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeConnection( ResultSet rs){
        try {
            if (rs!=null){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeConnection( Connection conn){
        try {
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            threadLocal.remove();
        }
    }
    public static void closeConnection( Connection conn,PreparedStatement pstmt,ResultSet rs){
       closeConnection(rs);
       closeConnection(pstmt);
       closeConnection(conn);
    }
    public static void closeConnection(PreparedStatement pstmt,ResultSet rs){
       closeConnection(rs);
       closeConnection(pstmt);
    }

//    public static void main(String[] args) {
//        Connection connection = getConnection();
//        System.out.println(connection);
//    }
}
