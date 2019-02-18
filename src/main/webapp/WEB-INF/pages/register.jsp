<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OnlineJudge</title>
        <link href="img/hiho.ico" rel="shortcut icon" type="image/x-icon">        <link type="text/css" rel="stylesheet" href="https://static.hihocoder.com/styles/home.css?1496820864.css">
        <script src="js/lib/jquery3.3.1-jqueryui1.12.1/jquery-3.3.1.js" charset="utf-8"></script>
        <script src="js/lib/md5.js" charset="utf-8"></script>
    </head>
    <body style="">
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
            <div class="register">
            <h2>注册</h2>
            <div class="row">
                <main id="main" class="col-xs-5">
                    <form class="form" action="" method="post">
                        <div class="form-group">
                            <input type="text" name="username" id="register_username" class="form-control input-lg" placeholder="输入学号">
                            <br>
                            <input type="password" name="password" id="register_password" class="form-control input-lg" placeholder="输入密码">
                            <br>
                            <input type="password" name="repassword" id="register_repeat_password" class="form-control input-lg" placeholder="重复密码">
                        	<br>
                        </div>
                        <button type="button" onclick="register()" class="btn btn-primary btn-lg">注册</button>
                    </form>
                </main>
            </div>
            </div> 
        </div>
        </div>

    </body>

    <script>
        function register() {
            var username = $("#register_username").val();
            var password = $("#register_password").val();
            var password_repeat = $("#register_repeat_password").val();
            if(username==="" || username==null){
                alert("学号不能为空！");
                return false;
            }
            if(password==="" || password==null){
                alert("密码不能为空！");
                return false;
            }
            if(password_repeat==="" || password_repeat==null){
                alert("请重复密码！");
                return false;
            }
            if(password !== password_repeat){
                alert("两次密码输入不同！");
                return false;
            }
            var md5_password = hex_md5(password);
            var ajax_data={username:username,password:md5_password};
            $.ajax({
                type:"POST",
                url:"register.jhtml",
                data:ajax_data,
                dataType:'json',
                success:function(msg){
                    if(msg.result=="-1")
                        alert("注册失败！");
                    else if(msg.result=="0")
                        alert("该学号已被占用！请重新输入！");
                    else if(msg.result=="1") {
                        alert("注册成功，请手动登录！");
                        window.location.href="gotoIndexPage.jhtml";
                    }
                }
            });
        }


    </script>
</html>