package com.admin.controller;

import com.admin.entity.GType;
import com.admin.service.GTypeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/page/admin/toregister.do")
public class ToRegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext application = request.getServletContext();
        GTypeService gTypeService = new GTypeService();
          List<GType> gTypeList = gTypeService.selectAllGType();
        request.setAttribute("gTypeList", gTypeList);
        request.getRequestDispatcher("/page/admin/register.jsp").forward(request,response);
    }
}
