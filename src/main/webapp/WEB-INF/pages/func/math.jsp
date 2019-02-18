<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.oj.entity.UserEntity" %>
<%@ page import="com.oj.entity.MathProblemEntity" %>
<%@ page import="java.util.ArrayList" %>
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
			ArrayList<MathProblemEntity> mathProblemEntityArrayList = (ArrayList<MathProblemEntity>) request.getAttribute("MathProblemList");
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
				<button type="button" onclick="change_math_problem()" class="btn btn-success"> 改变题目 </button>
				<button type="button" onclick="show_math_ans()" class="btn btn-success"> 显示答案 </button>
				<button type="button" onclick="hide_math_ans()" class="btn btn-success"> 隐藏答案 </button>
			</div>
			<ul id="math_problems" style="margin-left: 60px; margin-top: 60px; font-family: 新宋体; font-size: 20px;">
				<c:forEach items="<%=mathProblemEntityArrayList %>" var="mpe">
					<li style="margin-top: 5px; display: inline;">${mpe.problem}&nbsp;=&nbsp;<input type="text" style="display: inline; float: relative; margin-left: 0px;"/></li>
					<input type="text" class="math_ans_class" style="display: none;" value="${mpe.ans}"/>
					<br/><br/>
				</c:forEach>
			</ul>

		</div>
		</div>
		<div>
			<a id="gotop" href="#">
				<span>▲</span>
			</a>
		</div>
	</body>

	<script>
		function change_math_problem() {
			window.location.reload();
        }

        function show_math_ans() {
            $(".math_ans_class").css("color", "red");
            $(".math_ans_class").css("float", "relative");
            $(".math_ans_class").attr("disabled", "disabled");
            $(".math_ans_class").css("display", "inline");
        }

        function hide_math_ans() {
            $(".math_ans_class").css("display", "none");
        }

	</script>
</html>