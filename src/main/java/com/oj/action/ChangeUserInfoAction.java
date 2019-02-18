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

@WebServlet(name = "ChangeUserInfoAction")
public class ChangeUserInfoAction extends HttpServlet {

    UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String schoolid = request.getParameter("school_id")==null?"":request.getParameter("school_id"),
                name = request.getParameter("real_name")==null?"":request.getParameter("real_name"),
                sex = request.getParameter("sex")==null?"":request.getParameter("sex"),
                grade = request.getParameter("grade")==null?"":request.getParameter("grade");
        String classs_str = request.getParameter("classs");
        int classs = 0;
        if(!classs_str.equals("")) classs = Integer.parseInt(classs_str);

        UserEntity userEntity = new UserEntity(schoolid, null, name, sex, grade, classs);
        //System.out.println(userEntity.toString());
        boolean flag = userDao.updateUserInfo(userEntity);

        PrintWriter printWriter = response.getWriter();
        if(flag){
            printWriter.write("{\"result\":\"1\"}");
            request.getSession().invalidate();
            UserEntity userEntity1 = userDao.getUser(schoolid);
            request.getSession().setAttribute("UserEntity", userEntity1);
            System.out.println("[*] 用户信息修改成功。");
        }
        else{
            printWriter.write("{\"result\":\"-1\"}");
            System.out.println("[*] 用户信息修改失败！");
        }
        printWriter.flush();
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
