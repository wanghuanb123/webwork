package com.user.service;

import com.foods.dao.FoodsDAO;
import com.foods.entity.Foods;
import com.foods.utils.ConnectionUtil;
import com.foods.vo.SearchVo;
import com.user.dao.UserDAO;
import com.user.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    /*
     * 查询所有用户的方法
     * */
    public List<User> selectAllUser(){
        Connection connection = ConnectionUtil.getConnection();
        try {
            return userDAO.showAllUser(connection);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            ConnectionUtil.closeConnection(connection);
        }
    }

    /*
     * 按用户名字查询用户的方法
     * */
    public List<User> selectUserByUserName(String userName){
        Connection connection = ConnectionUtil.getConnection();

        try {
            List<User> userList = userDAO.showUserByUserName(userName, connection);
            return userList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            ConnectionUtil.closeConnection(connection);
        }
    }

    /*
     * 按菜号查询用户的方法
     * */
    public User selectUserByUserId(int userId){
        Connection connection = ConnectionUtil.getConnection();

        try {
            return userDAO.findUserByUserId(userId,connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            ConnectionUtil.closeConnection(connection);
        }
    }

    /*
     * 修改用户的方法
     * */
    public Boolean alterUser(User user){

        Connection connection = ConnectionUtil.getConnection();

        try {
            connection.setAutoCommit(false);
            userDAO.alterUserByUserID(user,connection);
            connection.commit();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(throwables);
        }finally {
            ConnectionUtil.closeConnection(connection);
        }
    }


    /*
     *删除用户的方法
     * */
    public void deleteUserByUserId(int userId){

        Connection connection = ConnectionUtil.getConnection();

        try {
            connection.setAutoCommit(false);

            userDAO.deleteUser(userId,connection);

            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw  new RuntimeException(throwables);
        } finally {
            ConnectionUtil.closeConnection(connection);
        }
    }

}
