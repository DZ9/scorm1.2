<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome to Online Study！</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="theme/css/bootstrap-3.1.0.min.css">
	<link rel="stylesheet" type="text/css" href="theme/css/index.css">
	<script type="text/javascript" src="theme/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="theme/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	<div class="container">
  		<div class="col-md-5 col-md-offset-3" id="content">
  		<form id="login" class="form" role="form" method="post" action="servlet/Login">
  		 <strong>用户登录:</strong>
  		 <br><br>
		  <div class="form-group">
		    <label class="sr-only" for="exampleInputEmail2">Email address</label>
		    <input type="text" class="form-control" id="exampleInputEmail2" name="username" placeholder="请输入用户名">
		  </div>
		  <div class="form-group">
		    <label class="sr-only" for="exampleInputPassword2">Password</label>
		    <input type="password" class="form-control" name="password" id="exampleInputPassword2" placeholder="请输入密码">
		  </div>
		  
		  
		  <button type="submit" class="btn btn-primary" id="loginbtn">登录</button>
		  <a href="view/user/userRegister.jsp"><button id="register" type="button" class="btn btn-default">注册</button></a>
		</form>	
  		</div>
  		
  	</div>
    
  </body>
</html>
