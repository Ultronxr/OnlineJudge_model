<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.oj.entity.UserEntity" %>
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
		<script src="js/lib/md5.js" charset="utf-8"></script>
		<link type="text/css" rel="stylesheet" href="css/homeselector.css">
	</head>
	<body style="">
		<%
			UserEntity userEntity = (UserEntity) session.getAttribute("UserEntity");
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
			<div id="content_head">
				<ul class="nav nav-tabs" style="margin-top: 10px;">
					<li class="active"><a onclick="change_ul('1')">语文</a></li>
					<li><a onclick="change_ul('2')">数学</a></li>
				</ul>
			</div>
			<div class="row" style="margin-top: 30px;position: relative;">
				<div id="chin_div" style="margin-left: 50px;">
					<form class="form-horizontal col-xs-10" action="" method="post" role="form">
						<div class="form-group">
							<button type="button" onclick="chin_submit('1')" class="btn btn-success"> 古诗背诵 </button>
						</div>
						<div class="form-group">
							<button type="button" onclick="chin_submit('2')" class="btn btn-success"> 古诗填空 </button>
						</div>
						<%--<div class="form-group">--%>
							<%--<button type="button" onclick="chin_submit('3')" class="btn btn-success"> 古诗默写 </button>--%>
						<%--</div>--%>
					</form>
				</div>
				<div id="math_div" style="display: none; margin-left: 50px;">
					<form class="form-horizontal col-xs-10" action="gotoMathPage.jhtml" method="post" role="form" onsubmit="math_submit()">
						<div class="form-group">
							<label for="problem_cate_selector" class="col-xs-2 control-label">选择四则运算</label>
							<div class="col-xs-5" id="problem_cate_selector" style="font-size: 20px;">
								加&nbsp;<input type="checkbox" name="plus_select" id="problem_cate_selector_1" value="plus" checked="checked" />&nbsp;&nbsp;
								减&nbsp;<input type="checkbox" name="minus_select" id="problem_cate_selector_2" value="minus" />&nbsp;&nbsp;
								乘&nbsp;<input type="checkbox" name="multiply_select" id="problem_cate_selector_3" value="multiply" />&nbsp;&nbsp;
								除&nbsp;<input type="checkbox" name="divide_select" id="problem_cate_selector_4" value="divide" />&nbsp;&nbsp;
							</div>
						</div>
						<div class="form-group">
							<label for="problem_number_selector" class="col-xs-2 control-label">选择题目数量</label>
							<div class="col-xs-5" id="problem_number_selector" style="font-size: 20px;">
								10&nbsp;<input type="radio" name="number_select" id="problem_number_selector_1" value="10" checked="checked" />&nbsp;&nbsp;
								20&nbsp;<input type="radio" name="number_select" id="problem_number_selector_2" value="20" />&nbsp;&nbsp;
								50&nbsp;<input type="radio" name="number_select" id="problem_number_selector_3" value="50" />&nbsp;&nbsp;
								100&nbsp;<input type="radio" name="number_select" id="problem_number_selector_4" value="100" />&nbsp;&nbsp;
							</div>
						</div>
						<div class="form-group" style="margin-left: 15px;">
							<button type="submit" <%--onclick="math_submit()"--%> class="btn btn-success"> 确定 </button>
						</div>
					</form>
				</div>
			</div>


		</div>
		</div>
	</body>

	<script>
		var pns = "10";
        $(function() {
            $("#content_head li a").click(function(){
                $(this).parent().addClass("active");
                $(this).parent().siblings().removeClass("active");
            });

            $("input[type='radio']").click(function(){
                pns = $(this).val();
                $(this).val(pns);
            });
        });

        function change_ul(num) {
            $("#chin_div").hide();
            $("#math_div").hide();
            if(num === '1' || num == 1) $("#chin_div").show();
            if(num === '2' || num == 2) $("#math_div").show();
        }

        function chin_submit(num) {
            if(num === '1' || num == 1) window.location.href="gotoGushibeisongPage.jhtml";
            if(num === '2' || num == 2) window.location.href="gotoGushitiankongPage.jhtml";
            //if(num === '3' || num == 3) window.location.href="gotoGushimoxiePage.jhtml";
        }
        
        function math_submit() {

            if($("#problem_cate_selector_1").is(':checked')) $("#problem_cate_selector_1").val($("#problem_cate_selector_1").val()+'_checked');
            if($("#problem_cate_selector_2").is(':checked')) $("#problem_cate_selector_2").val($("#problem_cate_selector_2").val()+'_checked');;
            if($("#problem_cate_selector_3").is(':checked')) $("#problem_cate_selector_3").val($("#problem_cate_selector_3").val()+'_checked');;
            if($("#problem_cate_selector_4").is(':checked')) $("#problem_cate_selector_4").val($("#problem_cate_selector_4").val()+'_checked');;

            return true;
        }


	</script>
</html>