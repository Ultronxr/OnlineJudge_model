package com.oj.action.gotopage;

import com.oj.dao.PoetryDao;
import com.oj.daoImpl.PoetryDaoImpl;
import com.oj.entity.PoetryEntity;
import com.oj.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GotoGushibeisongPageAction")
public class GotoGushibeisongPageAction extends HttpServlet {

    private PoetryDao poetryDao = new PoetryDaoImpl();
    private ArrayList<PoetryEntity> poetryEntityArrayList = poetryDao.getPoetryList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int rn = Utils.intRangedRandNum(0, poetryEntityArrayList.size()-1);
        PoetryEntity poetryEntity = poetryEntityArrayList.get(rn);
        String content = poetryEntity.getContent();
        content = content.replace("，","，<br/>");
        content = content.replace("？","？<br/>");
        content = content.replace("。","。<br/>");
        content = content.replace("；","；<br/>");
        content = content.replace("！","！<br/>");
        poetryEntity.setContent(content);
        request.setAttribute("PoetryEntity", poetryEntity);

        request.getRequestDispatcher("/WEB-INF/pages/func/gushibeisong.jsp").forward(request, response);
        System.out.println("[*] 跳转到gushibeisong页面。");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
