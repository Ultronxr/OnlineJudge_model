<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.oj.entity.UserEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.oj.entity.PoetryEntity" %>
<%@ page import="com.oj.utils.Utils" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
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
	</head>
	<body style="">
		<%
			UserEntity userEntity = (UserEntity) session.getAttribute("UserEntity");
			PoetryEntity poetryEntity = (PoetryEntity) request.getAttribute("PoetryEntity");
		%>
		<div id="wrap">
			<nav id="tl-top-navbar" class="navbar navbar-inverse">
			<div class="collapse navbar-collapse">
			<div class="container">
			<a href="gotoIndexPage.jhtml"><img src="img/00.png" width="200" height="50"></a>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=userEntity.getSchool_id() %><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="gotoUserinfoPage.jhtml">账户设置</a></li>
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
			<div class="form-group" style="margin-left: 15px;">
				<button type="button" onclick="change_poetry_next()" href="changeBeisongPoetry.jhtml" class="btn btn-success"> 下一首 </button>
			</div>
			<div class="row" style="margin-top: 30px;position: relative;">
				<div id="poetry_div">
					<p style="font-family: 微软雅黑; font-size: 40px; text-align: center" id="poetry_title"><%=poetryEntity.getTitle() %></p>
                    <br/>
                    <p style="font-family: 新宋体; font-size: 22px; text-align: center;" id="poetry_dynasty">[<%=poetryEntity.getDynasty() %>]</p>
                    <p style="font-family: 新宋体; font-size: 22px; text-align: center;" id="poetry_author"><%=poetryEntity.getAuthor() %></p>
                    <br/>
					<p style="font-family: 华文宋体; font-size: 28px; text-align: center" id="poetry_content"><%=poetryEntity.getContent() %></p>
				</div>
			</div>

		</div>
		</div>
		<div>
			<a id="gotop" href="#">
				<span>▲</span>
			</a>
		</div>
	</body>

	<script>
        function change_poetry_next() {
            $.ajax({
                type:"POST",
                url:"changeBeisongPoetry.jhtml",
                dataType:'json',
                success:function(msg){
                    $("#poetry_title").html(msg.title);
                    $("#poetry_dynasty").html('['+msg.dynasty+']');
                    $("#poetry_author").html(msg.author);
                    $("#poetry_content").html(msg.content);
                }
            });
        }

	</script>
</html>