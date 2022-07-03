package com.admin.controller;

import com.admin.entity.Admin;
import com.admin.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* 登录的servlet
* */
@WebServlet("/page/admin/login.do")
public class AdminLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adminName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");

        AdminService adminService = new AdminService();
        try {
            Admin admin = new Admin(null, adminName, adminPassword, null);
            adminService.doLogin(admin);
            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);
            response.sendRedirect("/OFM/page/menus/showfoods.do");
        }catch (Exception e){
            request.setAttribute("err", e.getMessage());
            request.getRequestDispatcher("/page/admin/login.jsp").forward(request, response);
        }
    }
}
