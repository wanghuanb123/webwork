package com.foods.controller;

import com.foods.entity.Foods;
import com.foods.service.FoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
* 展示菜单的servlet
* */
@WebServlet("/page/menus/showfoods.do")
public class ShowMenusController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FoodsService foodsService = new FoodsService();
        try {
            List<Foods> foodsList = foodsService.selectAllFoods();
            request.setAttribute("foodsList", foodsList);
            request.getRequestDispatcher("/page/menus/showmenus.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
