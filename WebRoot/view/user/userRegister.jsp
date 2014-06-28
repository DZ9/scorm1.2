<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome to Doxie's Little Store</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="theme/css/bootstrap-3.1.0.min.css">
	<link rel="stylesheet" type="text/css" href="theme/css/user/header.css">
	<link rel="stylesheet" type="text/css" href="theme/css/user/userRegister.css">
	<script type="text/javascript" src="theme/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="theme/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="theme/js/userRegister.js"></script>

  </head>
  
  <body>
    <div id="header" class="container highlight">
  		<h1 class="text-left">欢迎光临！</h1>
  		
		<!-- <form id="login" class="form-inline" role="form">
		  <div class="form-group">
		    <label class="sr-only" for="exampleInputEmail2">Email address</label>
		    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Enter email">
		  </div>
		  <div class="form-group">
		    <label class="sr-only" for="exampleInputPassword2">Password</label>
		    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password">
		  </div>
		  <button type="submit" class="btn btn-primary">登录</button>
		  <button type="button" class="btn btn-default">注册</button>
		</form>	
		 -->
  	</div>
  	
  	<div id="content" class="container"> 
			<ol id="top-nav" class="breadcrumb">
			  <li><a href="servlet/showIndex">首页</a></li>
			  <li class="active">注册</li>
			</ol>
	</div>
	
	<div id="info" class="container">
		<form id="register" action="servlet/Register" method="post" class="form-horizontal col-sm-offset-3" actionrole="form">
		  <div class="form-group">
		    <label for="exampleInputEmail2" class="col-sm-2 control-label">学号：</label>
		    <div class="col-sm-4">
		      <input type="text" name="stuNum" class="form-control" id="username" placeholder="请输入学号">
		      <span id="uerror" style="display:none">请输入学号</span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail2" class="col-sm-2 control-label">用户名：</label>
		    <div class="col-sm-4">
		      <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名">
		      <span id="uerror" style="display:none">请输入用户名</span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail2" class="col-sm-2 control-label">电子邮箱：</label>
		    <div class="col-sm-4">
		      <input type="email" name="email" class="form-control" id="email" placeholder="请输入电子邮箱">
		      <span id="eerror" style="display:none">请输入电子邮箱</span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail2" class="col-sm-2 control-label">密码：</label>
		    <div class="col-sm-4">
		      <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码">
		      <span id="perror" style="display:none">请输入密码</span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail2" class="col-sm-2 control-label">重复密码：</label>
		    <div class="col-sm-4">
		      <input type="password" class="form-control" id="repassword" placeholder="请重复密码">
		      <span id="rperror" style="display:none">请重复输入密码</span>
		    </div>
		  </div>
		  
		  <div class="form-group prop">
			    <label for="exampleInputEmail2" class="col-sm-2 control-label">选择专业：</label>
			    <div class="col-sm-5">
			      <select class="form-control" name="major">
				  <option>历史</option>
				  <option>科技</option>
				  <option>艺术</option>
				  </select>
			    </div>
			  </div>
		  <button id="sub" type="submit" class="btn btn-primary col-sm-offset-2">注册</button>
		</form>	
	</div>
  </body>
</html>
