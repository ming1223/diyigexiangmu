package com.oraclewdp.big.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.big.biz.BookListBiz;
import com.oraclewdp.big.biz.impl.BookListBizImpl;
import com.oraclewdp.big.model.Book;
import com.oraclewdp.big.util.PageConstant;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet(name="bookList",value = "/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strCurrentPage = request.getParameter("currentPage");
		if (strCurrentPage == null) {
			strCurrentPage = "1";
		}
		int currentPage = Integer.parseInt(strCurrentPage);
		String name = request.getParameter("shuming");
		String strxid = request.getParameter("xid") == null ? "-1" : request.getParameter("xid");
		int xid = Integer.parseInt(strxid);
		String strbid = request.getParameter("bid") == null ? "-1" : request.getParameter("bid");
		int bid = Integer.parseInt(strbid);
		BookListBiz bookListBiz = new BookListBizImpl();
		List<Book> ls = bookListBiz.save(currentPage, name, xid);
		int totalRow = bookListBiz.totalRow(name, xid);
		int totalPage = totalRow % PageConstant.PAGE_SIZE == 0 ? totalRow / PageConstant.PAGE_SIZE: totalRow / PageConstant.PAGE_SIZE + 1;
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("bid", bid);

		request.setAttribute("xid", xid);

		request.setAttribute("name", name);
		request.setAttribute("ls", ls);
		request.getRequestDispatcher("booklist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
