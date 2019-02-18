package com.oj.dao;

import com.oj.entity.UserEntity;

public interface UserDao {

    UserEntity userLogin(String username, String md5password);

    UserEntity getUser(String username);

    boolean userRegister(UserEntity userEntity);

    boolean updateUserInfo(UserEntity userEntity);

    boolean updateUserPwd(String schoolid, String md5password);

}
