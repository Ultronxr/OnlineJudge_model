package com.oj.daoImpl;

import com.oj.dao.AdminDao;
import com.oj.entity.AdminEntity;
import com.oj.entity.UserEntity;
import com.oj.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public AdminEntity adminLogin(String username, String md5password){

        String sql = "SELECT * FROM `admin` WHERE `username`=? AND `password`=?";
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        AdminEntity adminEntity = null;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, md5password);
            rs = ps.executeQuery();
            if (rs.next()){
                adminEntity = new AdminEntity();
                adminEntity.setId(rs.getInt(1));
                adminEntity.setUsername(rs.getString(2));
                adminEntity.setPassword(rs.getString(3));
            }
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] com.oj.daoImpl.AdminDaoImpl - adminLogin() 数据库连接出错");
        }finally {
            JDBCUtil.closeConnection(rs, ps, con);
        }

        return adminEntity;
    }


    @Override
    public boolean adminRegister(AdminEntity adminEntity){
        if(adminEntity == null) return false;

        String sql = "INSERT INTO `admin` (username, password) VALUES(?,?)";

        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        int flag = -1;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, adminEntity.getUsername());
            ps.setString(2, adminEntity.getPassword());
            flag = ps.executeUpdate();
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] com.oj.daoImpl.AdminDaoImpl - adminRegister() 数据库连接出错");
        }finally {
            JDBCUtil.closeConnection(null, ps, con);
        }

        return flag >= 0;
    }
}
