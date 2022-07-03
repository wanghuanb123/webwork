package com.user.Controller;

import com.foods.entity.Foods;
import com.foods.entity.Type;
import com.foods.service.FoodsService;
import com.user.entity.UType;
import com.user.entity.User;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page/user/alteruser.do")
public class AlterUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String userName = request.getParameter("userName");
        String userAccount = request.getParameter("userAccount");
        String userpassword = request.getParameter("userPassword");
        String userAddress = request.getParameter("userAddress");
        String userTel = request.getParameter("userTel");
        int uTypeId = Integer.parseInt(request.getParameter("uTypeId"));

        int userId = Integer.parseInt(request.getParameter("userId"));

        User user = new User(userId, userName, userAccount, userpassword, userAddress, userTel, new UType(uTypeId, null));

        UserService userService = new UserService();
        try {
            //此步正式蒋用户信息添加到数据库
            userService.alterUser(user);
            response.sendRedirect("/OFM/page/user/showuser.do");
        }catch (Exception e){
            request.setAttribute("err", e.getMessage());
            request.getRequestDispatcher("/page/user/alteruser.do").forward(request, response);
        }

    }
}
