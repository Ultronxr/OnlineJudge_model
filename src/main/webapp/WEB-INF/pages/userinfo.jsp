<%@ page import="com.oj.entity.UserEntity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<script src="js/lib/md5.js" charset="utf-8"></script>
	</head>
	<body>
	<%
		UserEntity userEntity = (UserEntity) session.getAttribute("UserEntity");
		String schoolid_show = userEntity.getSchool_id();
		String name_show = userEntity.getName()==null?"":userEntity.getName();
		String sex_show = userEntity.getSex()==null?"":userEntity.getSex();
		String grade_show = userEntity.getGrade()==null?"":userEntity.getGrade();
		int classs = userEntity.getClasss();
		String classs_show = "";
		if(classs!=0) classs_show = String.valueOf(classs);
	%>
		<div id="wrap">
		<nav id="tl-top-navbar" class="navbar navbar-inverse">
		<div class="collapse navbar-collapse">
		<div class="container">
			<a href="gotoIndexPage.jhtml"><img src="img/00.png" width="200" height="50"></a>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=schoolid_show %> <b class="caret"></b></a>
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
	  			<li class="active"><a href="gotoUserinfoPage.jhtml">用户信息</a></li>
			  	<li><a href="gotoEditpwdPage.jhtml">修改密码</a></li>
			</ul><div class="row" style="margin-top: 30px;position: relative;">
		<form class="form-horizontal col-xs-10" action="" method="post" role="form">
			<div class="form-group">
				<label for="school_id" class="col-xs-2 control-label">学号</label>
				<div class="col-xs-5">
					<input type="text" class="form-control" id="school_id" value="<%=schoolid_show %>" disabled="disabled">
				</div>
			</div>
			<div class="form-group">
				<label for="real_name" class="col-xs-2 control-label">姓名</label>
				<div class="col-xs-5">
					<input type="text" class="form-control" id="real_name" value="<%=name_show %>" placeholder="输入姓名">
				</div>
			</div>
			<div class="form-group">
				<label for="sex" class="col-xs-2 control-label">性别</label>
				<div class="col-xs-5">
					<input type="text" class="form-control" id="sex" value="<%=sex_show %>" placeholder="输入“男”或“女”">
				</div>
			</div>
			<div class="form-group">
				<label for="grade" class="col-xs-2 control-label">年级</label>
				<div class="col-xs-5">
					<input type="text" class="form-control" id="grade" value="<%=grade_show %>" placeholder="输入“一~六”之间的中文数字">
				</div>
			</div>
			<div class="form-group">
				<label for="classs" class="col-xs-2 control-label">班级</label>
				<div class="col-xs-5">
					<input type="text" class="form-control" id="classs" value="<%=classs_show %>" placeholder="输入“1~20”之间的数字">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-xs-5">
					<button type="button" onclick="submitchange()" class="btn btn-success"> 保存修改 </button>
				</div>
			</div>
		</form>
	</div>
	</main>		
	</div>
	</div>
	</body>

	<script>
		function submitchange() {
            var school_id = $("#school_id").val();
            var real_name = $("#real_name").val();
            var sex = $("#sex").val();
            var grade = $("#grade").val();
            var classs = $("#classs").val();

            if(!(sex==="" || sex===null || sex==="男" || sex==="女")){
                alert("请输入正确的性别！");
                return;
			}
            if(!(grade==="" || grade===null || grade==="一" || grade==="二" || grade==="三" || grade==="四" || grade==="五" || grade==="六")){
                alert("请输入正确的年级！");
                return;
            }
            if(!(classs==="" || classs===null || (classs>=1 && classs<=20))){
                alert("请输入正确的班级！");
                return;
			}

            var ajax_data={school_id:school_id,real_name:real_name,sex:sex,grade:grade,classs:classs};
            $.ajax({
                type:"POST",
                url:"changeUserInfo.jhtml",
                data:ajax_data,
                dataType:'json',
                success:function(msg){
                    if(msg.result=="-1")
                        alert("修改失败！");
                    else if(msg.result=="1") {
                        alert("修改个人信息成功！");
                        window.location.reload();
                    }
                }
            });
        }

	</script>
</html>