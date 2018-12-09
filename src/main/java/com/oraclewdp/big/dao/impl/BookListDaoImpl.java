package com.oraclewdp.big.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oraclewdp.big.dao.BookListDao;
import com.oraclewdp.big.model.Book;
import com.oraclewdp.big.util.DBUtil;
import com.oraclewdp.big.util.PageConstant;

public class BookListDaoImpl implements BookListDao {

	@Override
	public List<Book> find(int currentPage,String name, int xid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql="select * from t_shu  where 1=1 ";
			
			if(name!=null&&!name.equals("")) {
				sql+=" and shuming like '%"+name+"%' ";
			}
			if(xid!=-1) {
				sql+=" and xid="+xid;
			}
			
			 sql+=" order by id desc limit " + ((currentPage-1)*PageConstant.PAGE_SIZE+1-1) + ","
						+ PageConstant.PAGE_SIZE;
			 stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<Book> ls = new ArrayList<>();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setXid(rs.getInt("xid"));
				book.setShuming(rs.getString("shuming"));
				book.setJiage(rs.getDouble("jiage"));
				book.setZuozhe(rs.getString("zuozhe"));
				book.setZishu(rs.getString("zishu"));
				book.setJianjie(rs.getString("jianjie"));
				book.setTupian(rs.getString("tupian"));
				book.setChuban(rs.getString("chuban"));
				book.setRiqi(rs.getDate("riqi"));
				ls.add(book);
			}
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, stmt, conn);
		}
		return null;
	}

	@Override
	public int total(String name, int xid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			String sql = "select count(*) from t_shu where 1=1";
			if(name!=null&&!name.equals("")) {
				sql+=" and shuming like '%"+name+"%' ";
			}
			if(xid!=-1) {
				sql+=" and xid="+xid;
			}
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, stmt, conn);
		}
		return 0;
	}

	@Override
	public Book edit(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql="select * from t_shu  where id="+id;
			 stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<Book> ls = new ArrayList<>();
			if (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setXid(rs.getInt("xid"));
				book.setShuming(rs.getString("shuming"));
				book.setJiage(rs.getDouble("jiage"));
				book.setZuozhe(rs.getString("zuozhe"));
				book.setZishu(rs.getString("zishu"));
				book.setJianjie(rs.getString("jianjie"));
				book.setTupian(rs.getString("tupian"));
				book.setChuban(rs.getString("chuban"));
				book.setRiqi(rs.getDate("riqi"));
				return book;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, stmt, conn);
		}
		
		return null;
	}

}
