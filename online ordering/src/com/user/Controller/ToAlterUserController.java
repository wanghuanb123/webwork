package com.user.Controller;

import com.foods.entity.Foods;
import com.foods.entity.Type;
import com.foods.service.FoodsService;
import com.foods.service.TypeService;
import com.user.entity.UType;
import com.user.entity.User;
import com.user.service.UTypeService;
import com.user.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/page/user/toalteruser.do")
public class ToAlterUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int userId = Integer.parseInt(request.getParameter("userId"));

        UserService userService = new UserService();
        User user = userService.selectUserByUserId(userId);

        ServletContext application = request.getServletContext();
        UTypeService uTypeService = new UTypeService();
        List<UType> uTypesList = uTypeService.selectAllType();

        request.setAttribute("uTypeList", uTypesList);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/page/user/alteruser.jsp").forward(request, response);
    }
}
