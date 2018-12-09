package com.oraclewdp.big.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.oraclewdp.big.biz.SmallTypeBiz;
import com.oraclewdp.big.biz.impl.SmallTypeBizimpl;
import com.oraclewdp.big.model.SmallType;

/**
 * Servlet implementation class ShuBigTypeServlet
 */
@WebServlet(name="shuBigType",value = "/shuBigType")
public class FindAllSmallTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllSmallTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Bid = request.getParameter("bid");
		String dataType=request.getParameter("callback");
		int bid = Integer.parseInt(Bid);
		SmallTypeBiz smallTypeBiz = new SmallTypeBizimpl();
		List<SmallType> list = smallTypeBiz.findAllByBid(bid);
		response.setContentType("text/javascript;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONArray jsonArray =new JSONArray(list);
		out.println(dataType+"("+jsonArray.toString()+")");
		out.flush();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
