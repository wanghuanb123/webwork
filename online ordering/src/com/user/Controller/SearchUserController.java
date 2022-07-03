package com.user.Controller;

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

/*
* 按用户名搜索用户的servlet
* */
@WebServlet("/page/user/searchuser.do")
public class SearchUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");

        try{
            UserService userService = new UserService();

            List<User>  userList = userService.selectUserByUserName(userName);

            request.setAttribute("userList",userList);
            request.getRequestDispatcher("/page/user/showuser.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            request.getRequestDispatcher("/page/user/showuser.jsp").forward(request,response);
        }

    }
}
