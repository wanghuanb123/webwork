package com.admin.service;

import com.admin.dao.AdminDAO;
import com.admin.entity.Admin;
import com.foods.utils.ConnectionUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminService {
    private AdminDAO adminDAO = new AdminDAO();

    /*
    * 登录验证的方法
    * */
    public Boolean doLogin(Admin admin){
        Connection connection = ConnectionUtil.getConnection();
        try {
            Admin admin1 = adminDAO.findAdminByAdminName(admin.getAdminName(), connection);
            if (admin1!=null){
//                匹配，密码
                if (admin1.getAdminPassword().equals(admin.getAdminPassword())){
                    return true;
                }else {
//                    System.out.println(admin.getAdminPassword());
//                    System.out.println(admin1.getAdminPassword());
                    throw new RuntimeException("密码错误");
                }
            }else {
                throw new RuntimeException("账号错误");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        } finally {
            ConnectionUtil.closeConnection(connection);
        }
    }


    /*
    * 注册管理员的方法
    * */
    public Boolean register(Admin admin){
        Connection connection = ConnectionUtil.getConnection();
        try {
            if (adminDAO.findAdminByAdminName(admin.getAdminName(), connection)==null){
                connection.setAutoCommit(false);
//                对密码进行加密
//                admin.setAdminPass(DigestUtils.md5Hex(admin.getAdminPass()));
                adminDAO.addAdmin(admin, connection);
                connection.commit();
                return  true;
            }else {
                throw new RuntimeException("用户名已存在！！！请重新输入！！！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(throwables);
        } finally {
            ConnectionUtil.closeConnection(connection);
        }
    }
}
