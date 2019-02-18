package com.oj.action.gotopage;

import com.oj.dao.MathDao;
import com.oj.daoImpl.MathDaoImpl;
import com.oj.entity.MathProblemEntity;
import com.oj.entity.MathSelectorCheckEntity;
import com.oj.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GotoMathPageAction")
public class GotoMathPageAction extends HttpServlet {

    MathDao mathDao = new MathDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MathSelectorCheckEntity mathSelector = new MathSelectorCheckEntity(request.getParameter("plus_select"),request.getParameter("minus_select"),request.getParameter("multiply_select"),request.getParameter("divide_select"),request.getParameter("number_select"));
        //System.out.println(mathSelector.toString());

        ArrayList<MathProblemEntity> mathProblemEntityArrayList = mathDao.getMathProblemList(mathSelector);

        request.removeAttribute("MathProblemList");
        request.setAttribute("MathProblemList", mathProblemEntityArrayList);
        request.getRequestDispatcher("/WEB-INF/pages/func/math.jsp").forward(request, response);
        System.out.println("[*] 跳转到math页面。");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
