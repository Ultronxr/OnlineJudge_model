package com.oj.action;

import com.oj.dao.UserDao;
import com.oj.daoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangeUserPwdAction")
public class ChangeUserPwdAction extends HttpServlet {

    UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String schoolid = request.getParameter("school_id");
        String md5newpwd = request.getParameter("new_pwd");

        boolean flag = userDao.updateUserPwd(schoolid, md5newpwd);

        PrintWriter printWriter = response.getWriter();
        if(flag){
            request.getSession().invalidate();
            printWriter.write("{\"result\":\"1\"}");
            System.out.println("[*] 修改密码成功。");
        }else{
            printWriter.write("{\"result\":\"-1\"}");
            System.out.println("[*] 修改密码失败。");
        }
        printWriter.flush();
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
