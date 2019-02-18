package com.oj.filter;

import com.oj.entity.UserEntity;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "PageFilter")
public class PageFilter implements Filter {

    private FilterConfig filterConfig;

    public void destroy() {
        System.out.println("[*] IndexOrHomePageFilter已删除。");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //System.out.println("[*] PageFilter正在工作...");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpServletRequest hrequest = (HttpServletRequest)request;
        HttpServletResponse hresponse = (HttpServletResponse)response;

        String path = hrequest.getContextPath();
        String basePath = hrequest.getScheme()+"://"+hrequest.getServerName()+":"+hrequest.getServerPort()+path+"/";

        UserEntity userEntity = (UserEntity) hrequest.getSession().getAttribute("UserEntity");

        if(userEntity != null){ //用户登录了
            if(hrequest.getServletPath().contains("gotoIndexPage")){
                hresponse.sendRedirect("gotoHomePage.jhtml");
                System.out.println("[*] Filter 拦截：gotoIndexPage.jhtml  转向：gotoHomePage.jhtml  原因：用户已经登录");
                return;
            }
            else{
                chain.doFilter(request, response);
                System.out.println("[*] Filter 放行。");
                return;
            }
        }else{ //用户未登录
            if(hrequest.getServletPath().contains("gotoHomePage")){
                hresponse.sendRedirect("gotoLoginPage.jhtml");
                System.out.println("[*] Filter 拦截：gotoHomePage.jhtml  转向：gotoLoginPage.jhtml  原因：用户未登录");
                return;
            }else if(hrequest.getServletPath().contains("gotoUserInfoPage")){
                hresponse.sendRedirect("gotoLoginPage.jhtml");
                System.out.println("[*] Filter 拦截：gotoUserInfoPage.jhtml  转向：gotoLoginPage.jhtml  原因：用户未登录");
                return;
            }else if(hrequest.getServletPath().contains("gotoEditpwdPage")){
                hresponse.sendRedirect("gotoLoginPage.jhtml");
                System.out.println("[*] Filter 拦截：gotoEditpwdPage.jhtml  转向：gotoLoginPage.jhtml  原因：用户未登录");
                return;
            }else if(hrequest.getServletPath().contains("gotoGushibeisongPage")){
                hresponse.sendRedirect("gotoLoginPage.jhtml");
                System.out.println("[*] Filter 拦截：gotoGushibeisongPage.jhtml  转向：gotoLoginPage.jhtml  原因：用户未登录");
                return;
            }else if(hrequest.getServletPath().contains("gotoGushitiankongPage")){
                hresponse.sendRedirect("gotoLoginPage.jhtml");
                System.out.println("[*] Filter 拦截：gotoGushitiankongPage.jhtml  转向：gotoLoginPage.jhtml  原因：用户未登录");
                return;
            }else if(hrequest.getServletPath().contains("gotoGushimoxiePage")){
                hresponse.sendRedirect("gotoLoginPage.jhtml");
                System.out.println("[*] Filter 拦截：gotoGushimoxiePage.jhtml  转向：gotoLoginPage.jhtml  原因：用户未登录");
                return;
            }else if(hrequest.getServletPath().contains("gotoMathPage")){
                hresponse.sendRedirect("gotoLoginPage.jhtml");
                System.out.println("[*] Filter 拦截：gotoMathPage.jhtml  转向：gotoLoginPage.jhtml  原因：用户未登录");
                return;
            }
            else{
                chain.doFilter(request, response);
                System.out.println("[*] Filter 放行。");
                return;
            }
        }

//        chain.doFilter(request, response);
//        System.out.println("[*] Filter 放行。");
//        return;

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("[*] PageFilter正在初始化...");
        this.filterConfig = config;
    }

}
