<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OnlineJudge</title>
        <link href="img/hiho.ico" rel="shortcut icon" type="image/x-icon">
        <link type="text/css" rel="stylesheet" href="https://static.hihocoder.com/styles/home.css?1496820864.css">
        <script src="js/lib/jquery3.3.1-jqueryui1.12.1/jquery-3.3.1.js" charset="utf-8"></script>
        <script src="js/lib/md5.js" charset="utf-8"></script>
    </head>
    <body>
        <div id="wrap">
        <nav id="tl-top-navbar" class="navbar navbar-inverse">
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
        <div id="content" class="container">
            <div class="login">
            <h2>登录</h2>
            <p class="login-des">输入学号和密码登录（<a href="gotoRegisterPage.jhtml">注册</a>）</p>
            <form class="form-inline" action="" method="post" <%--onsubmit="return login()"--%>>
                <div class="form-group">
                    <label class="sr-only">学号</label>
                    <input type="text" name="username" id="input_username" class="form-control input-lg" placeholder="输入学号">
                </div>
                <div class="form-group">
                    <label class="sr-only">登录密码</label>
                    <input type="password" name="password" id="input_password" class="form-control input-lg" placeholder="输入密码">
                </div>
                <button type="button" onclick="login()" class="btn btn-primary btn-lg">登录</button>
            </form>
            </div>          
        </div>
        </div>
    </body>


    <script>
        function login() {
            var username = $("#input_username").val();
            var password = $("#input_password").val();
            if(username==="" || username==null){
                alert("学号不能为空！");
                return false;
            }
            if(password==="" || password==null){
                alert("密码不能为空！");
                return false;
            }
            var md5_password = hex_md5(password);
            var ajax_data={username:username,password:md5_password};
            $.ajax({
                type:"POST",
                url:"login.jhtml",
                data:ajax_data,
                dataType:'json',
                success:function(msg){
                    if(msg.result=="-1")
                        alert("学号或密码错误！");
                    else if(msg.result=="1") {
                        alert("登录成功！");
                        window.location.href="gotoHomePage.jhtml";
                    }
                }
            });
        }



    </script>
</html>

