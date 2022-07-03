package com.foods.controller;

import com.foods.entity.Foods;
import com.foods.entity.Type;
import com.foods.service.FoodsService;
import com.foods.service.TypeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
* 去alterfoods的servlet
* */
@WebServlet("/page/menus/toalterfoods.do")
public class ToAlterFoodsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int foodsId = Integer.parseInt(request.getParameter("foodsId"));
        FoodsService foodsService = new FoodsService();
        Foods foods = foodsService.selectFoodsByFoodsId(foodsId);
        ServletContext application = request.getServletContext();
        TypeService typeService = new TypeService();
        List<Type> typeList = typeService.selectAllType();
        request.setAttribute("typeList", typeList);
        request.setAttribute("foods", foods);
        request.getRequestDispatcher("/page/menus/alterfoods.jsp").forward(request, response);
    }
}
