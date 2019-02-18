package com.oj.daoImpl;

import com.oj.dao.UserDao;
import com.oj.entity.AdminEntity;
import com.oj.entity.UserEntity;
import com.oj.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public UserEntity userLogin(String username, String md5password){
        String sql = "SELECT * FROM `user` WHERE `school_id`=? AND `password`=?";
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserEntity userEntity = null;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, md5password);
            rs = ps.executeQuery();
            if (rs.next()){
                userEntity = new UserEntity();
                userEntity.setId(rs.getInt(1));
                userEntity.setSchool_id(rs.getString(2));
                userEntity.setPassword(rs.getString(3));
                userEntity.setName(rs.getString(4));
                userEntity.setSex(rs.getString(5));
                userEntity.setGrade(rs.getString(6));
                userEntity.setClasss(rs.getInt(7));
            }
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] com.oj.daoImpl.UserDaoImpl - userLogin() 数据库连接出错");
        }finally {
            JDBCUtil.closeConnection(rs, ps, con);
        }

        return userEntity;
    }

    @Override
    public UserEntity getUser(String username) {
        String sql = "SELECT * FROM `user` WHERE `school_id`=?";
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserEntity userEntity = null;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()){
                userEntity = new UserEntity();
                userEntity.setId(rs.getInt(1));
                userEntity.setSchool_id(rs.getString(2));
                userEntity.setPassword(rs.getString(3));
                userEntity.setName(rs.getString(4));
                userEntity.setSex(rs.getString(5));
                userEntity.setGrade(rs.getString(6));
                userEntity.setClasss(rs.getInt(7));
            }
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] com.oj.daoImpl.UserDaoImpl - getUser() 数据库连接出错");
        }finally {
            JDBCUtil.closeConnection(rs, ps, con);
        }

        return userEntity;
    }


    @Override
    public boolean userRegister(UserEntity userEntity){
        if(userEntity == null) return false;

        String sql = "INSERT INTO `user` (school_id, password, name, sex, grade, classs) VALUES(?,?,?,?,?,?)";

        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        int flag = -1;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, userEntity.getSchool_id());
            ps.setString(2, userEntity.getPassword());
            ps.setString(3, userEntity.getName());
            ps.setString(4, userEntity.getSex());
            ps.setString(5, userEntity.getGrade());
            ps.setInt(6, userEntity.getClasss());
            flag = ps.executeUpdate();
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] com.oj.daoImpl.UserDaoImpl - userRegister() 数据库连接出错");
        }finally {
            JDBCUtil.closeConnection(null, ps, con);
        }

        return flag >= 0;
    }

    @Override
    public boolean updateUserInfo(UserEntity userEntity) {
        if(userEntity == null) return false;

        String sql = "UPDATE `user` SET name=?,sex=?,grade=?,classs=? WHERE school_id=?";

        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        int flag = -1;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, userEntity.getName());
            ps.setString(2, userEntity.getSex());
            ps.setString(3, userEntity.getGrade());
            ps.setInt(4, userEntity.getClasss());
            ps.setString(5, userEntity.getSchool_id());
            flag = ps.executeUpdate();
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] com.oj.daoImpl.UserDaoImpl - updateUserInfo() 数据库连接出错");
        }finally {
            JDBCUtil.closeConnection(null, ps, con);
        }

        return flag >= 0;
    }

    @Override
    public boolean updateUserPwd(String schoolid, String md5password) {
        String sql = "UPDATE `user` SET password=? WHERE school_id=?";

        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        int flag = -1;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, md5password);
            ps.setString(2, schoolid);
            flag = ps.executeUpdate();
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] com.oj.daoImpl.UserDaoImpl - updateUserPwd() 数据库连接出错");
        }finally {
            JDBCUtil.closeConnection(null, ps, con);
        }

        return flag >= 0;
    }

}
