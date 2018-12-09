package com.oraclewdp.big.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oraclewdp.big.biz.ShuAddBiz;
import com.oraclewdp.big.biz.impl.ShuAddBizimpl;
import com.oraclewdp.big.model.Book;
import com.oraclewdp.big.util.MyBeanUtils;

/**
 * Servlet implementation class DoEditServlet
 */
@WebServlet(name="doEdit",value = "/doEdit")
@MultipartConfig
public class DoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book shuadd= new Book();
		MyBeanUtils.populate(shuadd, request.getParameterMap(),"yyyy-MM-dd");
		Part part = request.getPart("tupian");
		String newfile =null;
		if (part.getHeader("Content-Disposition").contains("; filename=")) {
			if(part.getSubmittedFileName()!=null&&!part.getSubmittedFileName().equals("")) {
				String exe = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".") + 1);
				 newfile = UUID.randomUUID() + "." + exe;
				part.write(request.getServletContext().getRealPath("/upload/") + newfile);
			}
		}
		shuadd.setTupian(newfile);
		ShuAddBiz shuAddBiz = new ShuAddBizimpl();
		boolean ret = 	shuAddBiz.updata(shuadd);
		if(ret) {

			response.sendRedirect("bookList");
		}else {
			request.setAttribute("book", shuadd);
			request.getRequestDispatcher("Edit.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
