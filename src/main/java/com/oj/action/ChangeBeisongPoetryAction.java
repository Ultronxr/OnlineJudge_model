package com.oj.action;

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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ChangeBeisongPoetryAction")
public class ChangeBeisongPoetryAction extends HttpServlet {

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

        String res = "{\"title\":\""+poetryEntity.getTitle()+"\", \"dynasty\":\""+poetryEntity.getDynasty()+"\", \"author\":\""+poetryEntity.getAuthor()+"\", \"content\":\""+content+"\"}";
        PrintWriter printWriter = response.getWriter();
        printWriter.write(res);
        printWriter.flush();
        printWriter.close();

        System.out.println("[*] 获取新的beisong诗。");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
