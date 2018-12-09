package com.oraclewdp.big.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter",value = "/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if(request.getRequestURI().contains("/loginAdmin")||request.getRequestURI().contains("bower_components/")||request.getRequestURI().endsWith("login.jsp")||request.getRequestURI().endsWith("vcode.png")){
            chain.doFilter(req,resp);
            return;
        }
        if(request.getSession().getAttribute("admin")==null||!(Boolean) request.getSession().getAttribute("admin")){
            response.sendRedirect("login.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
