package com.oj.action.gotopage;

import com.oj.dao.PoetryDao;
import com.oj.daoImpl.PoetryDaoImpl;
import com.oj.entity.PoetryEntity;
import com.oj.entity.PoetrySubEntity;
import com.oj.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GotoGushitiankongPageAction")
public class GotoGushitiankongPageAction extends HttpServlet {

    PoetryDao poetryDao = new PoetryDaoImpl();
    ArrayList<PoetryEntity> poetryEntityArrayList =  poetryDao.getPoetryList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<PoetrySubEntity> poetrySubEntityArrayList =
                poetryDao.getPoetrySubList(poetryEntityArrayList, 15);

        request.removeAttribute("PoetrySubEntityList");
        request.setAttribute("PoetrySubEntityList", poetrySubEntityArrayList);
        request.getRequestDispatcher("/WEB-INF/pages/func/gushitiankong.jsp").forward(request, response);
        System.out.println("[*] 跳转到gushitiankong页面。");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
