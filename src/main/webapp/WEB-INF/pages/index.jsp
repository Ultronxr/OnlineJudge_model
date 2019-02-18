<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OnlineJudge</title>
        <link href="img/hiho.ico" rel="shortcut icon" type="image/x-icon">
        <%--<link type="text/css" rel="stylesheet" href="css/others/home.css">--%>
        <link type="text/css" rel="stylesheet" href="https://static.hihocoder.com/styles/home.css?1496820864.css">
        <script src="js/lib/jquery3.3.1-jqueryui1.12.1/jquery-3.3.1.js" charset="utf-8"></script>
        <script src="js/lib/md5.js" charset="utf-8"></script>
    </head>

    <body>
        <div id="wrap">
            <nav id="tl-top-navbar-index" class="navbar navbar-default">
            <div class="collapse navbar-collapse">
                <div class="container">
                    <a href="gotoIndexPage.jhtml"><img src="img/00.png" width="200" height="50"></a>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="gotoLoginPage.jhtml">登录</a></li>
                        <li><a href="gotoRegisterPage.jhtml">注册</a></li>
                    </ul>
                </div>
            </div>
            </nav>
            <style type="text/css">
                #tl-top-navbar-index .navbar-right {
                    padding-top: 0;
                }
                #tl-top-navbar-index .navbar-nav>li>a {
                    color: #CCC8C8;
                }
                #tl-top-navbar-index .navbar-nav>li>a:hover {
                    color: #FFF;
                }
                .navbar-default .navbar-nav>.open>a, .navbar-default .navbar-nav>.open>a:focus, .navbar-default .navbar-nav>.open>a:hover {
                    background-color: #080808;
                    color: #555;
                }
            </style>
            <style type="text/css" xmlns="http://www.w3.org/1999/html">body{background: #ffffff;}</style>
            <div class="site-intro">
                <div class="container">
                    <h2 class="site-intro-slogan">小学在线随机出题与生成答案自测系统</h2>
                    <br/>
                    <br/>
                    <style>.text-intto{color:#ccc;margin-top:10px;text-align:center;font-size:20px}</style>
                    <h3 class="text-intto">本站提供：用户注册、登录，<br/></h3>
                    <h3 class="text-intto">随机生成语文古诗词背诵填空、或数学四则运算题目，</h3>
                    <h3 class="text-intto">并自动生成正确答案，用以对比自己的回答的功能。</h3>
                    <br/>
                    <h3 class="text-intto">创作：东苑小学 三(2)班 王曼桐/方材</h3>
                </div>
            </div>
        </div>
    </body>
    
</html>