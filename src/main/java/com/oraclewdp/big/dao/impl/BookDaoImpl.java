package com.oraclewdp.big.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.oraclewdp.big.dao.ShuAddDao;
import com.oraclewdp.big.model.Book;
import com.oraclewdp.big.util.DBUtil;

public class BookDaoImpl implements ShuAddDao {

	@Override
	public boolean shuadd(Book shuadd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into t_shu(shuming,xid,jiage,zuozhe,zishu,jianjie,tupian,chuban,riqi) values(?,?,?,?,?,?,?,?,?)";
		    stmt = conn.prepareStatement(sql);
			stmt.setString(1,shuadd.getShuming());
			stmt.setInt(2, shuadd.getXid());
			stmt.setDouble(3, shuadd.getJiage());
			stmt.setString(4, shuadd.getZuozhe());
			stmt.setString(5, shuadd.getZishu());
			stmt.setString(6, shuadd.getJianjie());
			stmt.setString(7, shuadd.getTupian());
			stmt.setString(8, shuadd.getChuban());
			stmt.setDate(9,new java.sql.Date(shuadd.getRiqi().getTime()));
			int ret = stmt.executeUpdate();
			// 如果ret大于零，插入信息
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.free(stmt, conn);
		}
		return false;
	}

	@Override
	public int Del(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from t_shu where id="+id;
		    stmt = conn.prepareStatement(sql);
			int ret = stmt.executeUpdate();
			// 如果ret大于零，插入信息
			return ret;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.free(stmt, conn);
		}
		return 0;
	}

	@Override
	public boolean xiugai(Book shuadd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			if(shuadd.getTupian()==null) {
				String sql = "update t_shu set shuming=?,xid=?,jiage=?,zuozhe=?,zishu=?,jianjie=?,chuban=?,riqi=? where id=?";
			    stmt = conn.prepareStatement(sql);
				stmt.setString(1,shuadd.getShuming());
				stmt.setInt(2, shuadd.getXid());
				stmt.setDouble(3, shuadd.getJiage());
				stmt.setString(4, shuadd.getZuozhe());
				stmt.setString(5, shuadd.getZishu());
				stmt.setString(6, shuadd.getJianjie());
				stmt.setString(7, shuadd.getChuban());
				stmt.setDate(8,new java.sql.Date(shuadd.getRiqi().getTime()));
				stmt.setInt(9, shuadd.getId());
			}else {
				String sql = "update t_shu set shuming=?,xid=?,jiage=?,zuozhe=?,zishu=?,jianjie=?,tupian=?,chuban=?,riqi=? where id=?";
			    stmt = conn.prepareStatement(sql);
				stmt.setString(1,shuadd.getShuming());
				stmt.setInt(2, shuadd.getXid());
				stmt.setDouble(3, shuadd.getJiage());
				stmt.setString(4, shuadd.getZuozhe());
				stmt.setString(5, shuadd.getZishu());
				stmt.setString(6, shuadd.getJianjie());
				stmt.setString(7, shuadd.getTupian());
				stmt.setString(8, shuadd.getChuban());
				stmt.setDate(9,new java.sql.Date(shuadd.getRiqi().getTime()));
				stmt.setInt(10, shuadd.getId());
			}
			int ret = stmt.executeUpdate();
			// 如果ret大于零，插入信息
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.free(stmt, conn);
		}
		return false;
	}

}
