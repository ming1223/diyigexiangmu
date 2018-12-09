package com.oraclewdp.big.dao.impl;

import com.oraclewdp.big.dao.AdminDao;
import com.oraclewdp.big.model.Admin;
import com.oraclewdp.big.model.Book;
import com.oraclewdp.big.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoJdbcImpl implements AdminDao {
    @Override
    public boolean guanli(Admin admin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql="select * from t_guanli where name=? and pwd=? ";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,admin.getName());
            stmt.setString(2,admin.getPwd());
            rs = stmt.executeQuery();
            if (rs.next()) {
             return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.free(rs, stmt, conn);
        }
        return false;
    }
}
