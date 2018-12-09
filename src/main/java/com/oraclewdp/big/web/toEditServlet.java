package com.oraclewdp.big.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.big.biz.BookListBiz;
import com.oraclewdp.big.biz.SmallTypeBiz;
import com.oraclewdp.big.biz.impl.BookListBizImpl;
import com.oraclewdp.big.biz.impl.SmallTypeBizimpl;
import com.oraclewdp.big.model.Book;

/**
 * Servlet implementation class toEditServlet
 */
@WebServlet(name="toEdit",value = "/toEdit")
public class toEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		BookListBiz bookListBiz = new BookListBizImpl();
		Book book = bookListBiz.Edit(id);
		SmallTypeBiz smallTypeBiz = new SmallTypeBizimpl();
		int bid = smallTypeBiz.findEdit(book.getXid());
		request.setAttribute("book", book);
		request.setAttribute("bid", bid);
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
