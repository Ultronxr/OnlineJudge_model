package com.oj.dao;

import com.oj.entity.AdminEntity;

public interface AdminDao {

    AdminEntity adminLogin(String username, String md5password);

    boolean adminRegister(AdminEntity adminEntity);

}
