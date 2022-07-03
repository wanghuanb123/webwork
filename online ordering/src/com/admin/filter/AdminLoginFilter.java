package com.admin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* 登录的过滤器
* */
@WebFilter(filterName = "AdminLoginFilter")
public class AdminLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        if (session.getAttribute("admin")!=null){
            chain.doFilter(req, resp);
        }else {
            request.setAttribute("err", "请先登录");
            request.getRequestDispatcher("/page/admin/login.jsp").forward(request,response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
