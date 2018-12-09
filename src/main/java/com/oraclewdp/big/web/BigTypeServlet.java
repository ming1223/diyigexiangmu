package com.oraclewdp.big.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.big.biz.BigTypeBiz;
import com.oraclewdp.big.biz.impl.BigbyteBizimpl;

/**
 * Servlet implementation class BigByteWeb
 */
@WebServlet(name="login",value = "/login")
public class BigTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BigTypeServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String name=request.getParameter("name");
			BigTypeBiz bigbytebiz= new BigbyteBizimpl();
			boolean b =bigbytebiz.save(name);
			if(b) {
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else {
				request.setAttribute("name", name);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
	}

}
