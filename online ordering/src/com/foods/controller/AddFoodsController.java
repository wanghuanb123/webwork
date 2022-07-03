package com.foods.controller;

import com.foods.entity.Foods;
import com.foods.entity.Type;
import com.foods.service.FoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
* 添加菜品的servlet
* */
@WebServlet("/page/menus/addfoods.do")
public class AddFoodsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        接收参数
        String foodsName = request.getParameter("foodsName");
        String foodsInfo = request.getParameter("foodsInfo");
        double foodsPrice = Double.parseDouble(request.getParameter("foodsPrice"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));

//        封装对象
        Foods foods = new Foods(null, foodsName, foodsPrice, foodsInfo, new Type(typeId, null));
//        调用业务逻辑层
        FoodsService foodsService = new FoodsService();
        try{
            foodsService.addfoods(foods);
            response.sendRedirect("/OFM/page/menus/showfoods.do");

        }catch (Exception e){

            request.setAttribute("err", e.getMessage());
            request.getRequestDispatcher("/page/menus/toaddfoods.do").forward(request, response);
        }

    }
}
