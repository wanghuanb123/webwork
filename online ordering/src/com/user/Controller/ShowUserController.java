package com.user.Controller;

import com.foods.entity.Foods;
import com.foods.service.FoodsService;
import com.user.entity.User;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/page/user/showuser.do")
public class ShowUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        try {
            List<User> userList = userService.selectAllUser();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/page/user/showuser.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
