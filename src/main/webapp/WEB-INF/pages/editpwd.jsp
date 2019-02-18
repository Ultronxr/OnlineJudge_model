<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.oj.entity.UserEntity"%>

<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<meta property="qc:admins" content="25115412737374526375">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>OnlineJudge</title>
		<link href="img/hiho.ico" rel="shortcut icon" type="image/x-icon">
		<link type="text/css" rel="stylesheet" href="https://static.hihocoder.com/styles/home.css?1496820864.css">
		<script type="text/javascript" src="https://static.hihocoder.com/js/libs/jquery-1.10.2.min.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/api.js?1499873233.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/common.js?1496820864.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/framework/dropdown.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/framework/button.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/framework/alert.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/libs/tab.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/framework/collapse.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/framework/tooltip.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/framework/modal.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/framework/tag.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/framework/discuss.js?1457224552.js"></script>
		<script type="text/javascript" src="https://static.hihocoder.com/js/framework/contest.js?1457224552.js"></script>
        <script type="text/javascript" src="https://static.hihocoder.com/js/framework/popover.js?1457224552.js"></script>
		<script src="js/lib/jquery3.3.1-jqueryui1.12.1/jquery-3.3.1.js" charset="utf-8"></script>
		<script src="js/lib/md5.js" charset="utf-8"></script>
	</head>
	<body>
	<%
		UserEntity userEntity = (UserEntity) session.getAttribute("UserEntity");
		String schoolid_show = userEntity.getSchool_id();
		String pwd_show = userEntity.getPassword();
	%>
		<div id="wrap">
			<nav id="tl-top-navbar" class="navbar navbar-inverse">
			<div class="collapse navbar-collapse">
			<div class="container">
				<a href="gotoIndexPage.jhtml"><img src="img/00.png" width="200" height="50"></a>
				<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=schoolid_show %><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="gotoHomePage.jhtml">回到主页</a></li>
						<%--<c:if test="${ user.getRole() == 2}">--%>
							<%--<li><a href="<%=basePath %>admin.jsp">后台管理</a></li>--%>
						<%--</c:if>--%>
						<li><a href="logout.jhtml">退出登录</a></li>
					</ul>
				</li>
			</ul>
			</div>
			</div>
			</nav>			
			<div id="content" class="container">
			<main class="md-card fn-p10">
			<ul class="nav nav-tabs" style="margin-top: 10px;">
			  <li><a href="gotoUserinfoPage.jhtml">用户信息</a></li>
			  <li class="active"><a href="gotoEditpwdPage.jhtml">修改密码</a></li>
			</ul>	
		<div class="row" style="margin-top: 30px;">
		<form class="form-horizontal col-xs-8" role="form" action="" method="post" >
				<div class="form-group">
				<label for="old_pwd" class="col-xs-3 control-label">原密码</label>
				<div class="col-xs-5">
					<input type="password" class="form-control" id="old_pwd">
				</div>
				</div>
				<div class="form-group">
				<label for="new_pwd" class="col-xs-3 control-label">新密码</label>
				<div class="col-xs-5">
					<input type="password" class="form-control" id="new_pwd">
				</div>
				</div>
				<div class="form-group">
					<label for="repeat_pwd" class="col-xs-3 control-label">确认密码</label>
					<div class="col-xs-5">
						<input type="password" class="form-control" id="repeat_pwd">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-xs-5">
					<button type="button" onclick="submitpwdchange()" class="btn btn-success">保存修改</button>
					</div>
				</div>
		</form>
		</div>
		</main>			
		</div>
		</div>
	</body>

	<script>
		function submitpwdchange() {
		    var old_pwd = $("#old_pwd").val();
		    var new_pwd = $("#new_pwd").val();
		    var repeat_pwd = $("#repeat_pwd").val();

		    if(old_pwd==="" || old_pwd==null){
		        alert("请输入原密码！");
		        return;
			}
            if(new_pwd==="" || new_pwd==null){
                alert("请输入新密码！");
                return;
            }
            if(repeat_pwd==="" || repeat_pwd==null){
                alert("请重复输入新密码！");
                return;
            }
            if(new_pwd !== repeat_pwd){
                alert("两次输入的密码不一样！");
                return;
			}

			if(hex_md5(old_pwd) !== "<%=pwd_show %>"){
			    alert("原密码错误！无法修改！");
				return;
			}

            var md5_new_pwd = hex_md5(new_pwd);
            var ajax_data={school_id:"<%=schoolid_show%>",new_pwd:md5_new_pwd};
            $.ajax({
                type:"POST",
                url:"changeUserPwd.jhtml",
                data:ajax_data,
                dataType:'json',
                success:function(msg){
                    if(msg.result=="-1")
                        alert("修改密码失败！");
                    else if(msg.result=="1") {
                        alert("修改密码成功，请重新登录！");
                        window.location.href="gotoIndexPage.jhtml";
                    }
                }
            });
        }

	</script>

</html>