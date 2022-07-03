package com.admin.controller;

import com.admin.entity.Admin;
import com.admin.entity.GType;
import com.admin.service.AdminService;
import com.admin.service.GTypeService;
import com.foods.entity.Type;
import com.foods.service.TypeService;
import com.user.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/page/admin/register.do")
public class AdminRegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String adminName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");
        int typeId = Integer.parseInt(request.getParameter("gTypeId"));

        Admin admin = new Admin(null,adminName,adminPassword,new GType(typeId,null));

        try{
            AdminService adminService = new AdminService();
            adminService.register(admin);
            response.sendRedirect("/OFM/page/admin/login.jsp");

        }catch (Exception e){
            request.setAttribute("err", e.getMessage());
            request.getRequestDispatcher("/page/admin/toregister.do").forward(request, response);
        }
    }
}
