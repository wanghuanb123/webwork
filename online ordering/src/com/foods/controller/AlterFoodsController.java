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
* 修改菜品的servlet
* */
@WebServlet("/page/menus/alterfoods.do")
public class AlterFoodsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    /*
    * 接收
    * 封装
    * 调用
    * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String foodsName = request.getParameter("foodsName");
        double foodsPrice = Double.parseDouble(request.getParameter("foodsPrice"));
        String foodsInfo = request.getParameter("foodsInfo");
        int typeId = Integer.parseInt(request.getParameter("typeId"));

        int foodsId = Integer.parseInt(request.getParameter("foodsId"));
        String oldfoodsName = request.getParameter("oldfoodsName");


        Foods foods = new Foods(foodsId, foodsName, foodsPrice, foodsInfo, new Type(typeId, null));

        FoodsService foodsService = new FoodsService();
        try {
            foodsService.alterFoods(foods,oldfoodsName);
            response.sendRedirect("/OFM/page/menus/showfoods.do");
        }catch (Exception e){
            request.setAttribute("err", e.getMessage());
            request.getRequestDispatcher("/page/menus/alterfoods.do").forward(request, response);
        }

    }
}
