package com.oj.action;

import com.oj.dao.UserDao;
import com.oj.daoImpl.UserDaoImpl;
import com.oj.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterAction")
public class RegisterAction extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String md5password = request.getParameter("password");

        UserEntity checkUserEntity = userDao.getUser(username);
        PrintWriter printWriter = response.getWriter();
        if(checkUserEntity != null){
            printWriter.write("{\"result\":\"0\"}");
            printWriter.flush();
            printWriter.close();
            System.out.println("[*] 用户注册失败：学号重复！");
            return;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setSchool_id(username);
        userEntity.setPassword(md5password);

        boolean flag = userDao.userRegister(userEntity);

        if(flag){
            printWriter.write("{\"result\":\"1\"}");
            System.out.println("[*] 用户注册成功。");
        }else{
            printWriter.write("{\"result\":\"-1\"}");
            System.out.println("[*] 用户注册失败！");
        }
        printWriter.flush();
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
