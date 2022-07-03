package com.foods.controller;

import com.foods.entity.Foods;
import com.foods.entity.Type;
import com.foods.service.FoodsService;
import com.foods.service.TypeService;
import com.foods.vo.SearchVo;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/*
* 按菜品名字，类型搜索菜品的servlet
* */
@WebServlet("/page/menus/searchfoods.do")
public class SearchFoodsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext application = request.getServletContext();
        TypeService typeService = new TypeService();
        List<Type> typeList = typeService.selectAllType();
        application.setAttribute("typeList",typeList);

        SearchVo searchVo = new SearchVo();
        if (request.getParameter("foodsId")!=null&&!"".equals(request.getParameter("foodsId"))){
            searchVo.setFoodsId(Integer.parseInt(request.getParameter("foodsId")));
        }if (request.getParameter("foodsName")!=null&&!"".equals(request.getParameter("foodsName"))){
            searchVo.setFoodsName(request.getParameter("foodsName"));
        }if (request.getParameter("minFoodsPrice")!=null&&!"".equals(request.getParameter("minFoodsPrice"))){
            searchVo.setMinFoodsPrice(Double.parseDouble(request.getParameter("minFoodsPrice")));
        }if (request.getParameter("maxFoodsPrice")!=null&&!"".equals(request.getParameter("maxFoodsPrice"))){
            searchVo.setMaxFoodsPrice(Double.parseDouble(request.getParameter("maxFoodsPrice")));
        }if (request.getParameter("typeId")!=null&&!"".equals(request.getParameter("typeId"))){
            searchVo.setTypeId(Integer.parseInt(request.getParameter("typeId")));
        }



        FoodsService foodsService = new FoodsService();

        try {
            List<Foods> foodsList = foodsService.selectFoodsBySearchVO(searchVo);
            request.setAttribute("foodsList", foodsList);
            request.setAttribute("searchVO",searchVo);
            request.getRequestDispatcher("/page/menus/searchfoods.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
