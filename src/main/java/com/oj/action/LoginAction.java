package com.oj.action;

import com.oj.dao.UserDao;
import com.oj.daoImpl.UserDaoImpl;
import com.oj.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginAction")
public class LoginAction extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String md5password = request.getParameter("password");
        //System.out.println(username+" "+md5password);

        PrintWriter printWriter = response.getWriter();
        int flag = -1;

        UserEntity userEntity = userDao.userLogin(username, md5password);
        if(userEntity == null){
            flag = -1;
            System.out.println("[*] 用户登录失败。");
        }else{
            flag = 1;
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("UserEntity", userEntity);
            System.out.println("[*] 用户登录成功。");
        }
        printWriter.write("{\"result\":\""+flag+"\"}");
        printWriter.flush();
        printWriter.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
