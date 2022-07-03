package com.user.Controller;

import com.foods.service.FoodsService;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page/user/deleteuser.do")
public class DeleteUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int userId = Integer.parseInt(request.getParameter("userId"));

        UserService userService = new UserService();


        try {
            userService.deleteUserByUserId(userId);
            response.sendRedirect("/OFM/page/user/showuser.do");
        }catch (Exception e){
            request.setAttribute("err", e.getMessage());
            request.getRequestDispatcher("/page/user/showuser.do").forward(request, response);
        }
    }
}
