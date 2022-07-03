package com.foods.controller;

import com.foods.service.FoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 删除菜品的servlet
* */
@WebServlet("/page/menus/deletefoods.do")
public class DeleteFoodsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int foodsId = Integer.parseInt(request.getParameter("foodsId"));

        FoodsService foodsService = new FoodsService();
        try {
            foodsService.deleteFoodsByFoodsId(foodsId);
            response.sendRedirect("/OFM/page/menus/showfoods.do");
        }catch (Exception e){
            request.setAttribute("err", e.getMessage());
            request.getRequestDispatcher("/page/menus/showfoods.do").forward(request, response);
        }

    }
}
