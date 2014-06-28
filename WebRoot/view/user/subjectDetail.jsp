<%@ page language="java" import="java.util.*,com.idoxie.dishOL.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(path);

%>
<%
	Subject d  = (Subject)request.getAttribute("Subject");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<base href="<%=basePath%>">
<title>Welcome to Doxie's Little Store</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="theme/css/bootstrap-3.1.0.min.css">
<link rel="stylesheet" type="text/css" href="theme/css/user/header.css">
<link rel="stylesheet" type="text/css" href="theme/css/user/productDetail.css">
<script type="text/javascript" src="theme/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="theme/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="header" class="container highlight">
  		<h1 class="text-left">欢迎光临！</h1>
  		<div id="login" >
		 	欢迎你，<span id="name"><%= session.getAttribute("username") %></span>&nbsp;<span id="spcar">
		 	</span>&nbsp;<span id="list"><a href="servlet/MyAccount">个人中心</a></span>
		 	</span>&nbsp;<span id="list"><a href="view/logout.jsp">退出</a></span>
		 </div>
  	</div>
  	
  	<div id="content" class="container">
  		

		<ol id="top-nav" class="breadcrumb">
		  <li><a href="servlet/showIndex">首页</a></li>
		  <li class="active">课程</li>
		</ol>

  		
  		<div id="pic" class="col-md-4 thumbnail">
	      <img src="theme/img/<%= d.getPic() %>" alt="ddddd" class="img-center">
		</div>
  		<div id="info" class="col-md-7">
  			<h4><strong>课程名称：<%= d.getSubjectName() %></strong></h4>
  			
  			<p>类别：<strong class="text-danger" id="price"><%= d.getType() %></strong></p>
  			<form class="form-inline" action="servlet/registSubject" method="post">
				<input type="hidden" name="subjectName" value="<%= d.getSubjectName() %>">
				<button type="submit" class="btn btn-primary">注册课程</button>
  			</form>
  			  
  		</div>
  		
    </div>
    <div id="detail" class="container">
    	<h5>详细信息</h5>
    	<p>
    		<%= d.getDescription() %>
    	</p>
    </div>
</body>
</html>