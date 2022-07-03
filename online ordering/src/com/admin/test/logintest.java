package com.admin.test;

import com.admin.entity.Admin;
import com.admin.service.AdminService;

public class logintest {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        Admin admin = new Admin(null,"duyexuan","123321",null);
        if(adminService.doLogin(admin)){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }

    }
}
