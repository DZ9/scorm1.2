
<%@ page language="java" import="java.util.*,com.idoxie.dishOL.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(path);

%>
<%
	ArrayList<Subject> al = (ArrayList<Subject>)request.getAttribute("al");
		Iterator it = al.iterator();
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
	<link rel="stylesheet" type="text/css" href="theme/css/user/index.css">
	<script type="text/javascript" src="theme/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="theme/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  
  
	
  	<div id="header" class="container highlight">
  		<h1 class="text-left">欢迎光临！</h1>
  		<div id="login" >
		 	欢迎你，<span id="name"><%=session.getAttribute("username")%></span><!-- &nbsp;<span id="spcar"><a href="servlet/ShoppingCart">购物车</a> -->
		 	</span>&nbsp;<span id="list"><a href="servlet/MyAccount">个人中心</a></span>
		 	</span>&nbsp;<span id="list"><a href="view/logout.jsp">退出</a></span>
		 </div>
  	</div>
  	
    <div id="content" class="container">	
	  	<div class="row">
	  		<div id="nav-list">
		  		<div class="col-md-3 list-group nav">
		  		  <a href="servlet/showIndex" class="list-group-item">全部</a>	
				  <a href="servlet/showIndex?type=科技" class="list-group-item">科技</a>
				  <a href="servlet/showIndex?type=历史" class="list-group-item">历史</a>
				  <a href="servlet/showIndex?type=人文" class="list-group-item">人文</a>
				  
				</div>
	  		</div>
			
			<div id="food-list" data-spy="scroll" data-target="#nav" class="col-md-9">
				<%
					while(it.hasNext()) {
								Subject d = (Subject)it.next();
				%>
					<div class="col-md-4">
		   			<div class="thumbnail">
				      <img style="width:242px;height:152px;" src="theme/img/<%= d.getPic()%>" alt="ddddd">
				      <div class="caption text-center">
				        <h3><%= d.getSubjectName() %></h3>
				        <!-- <p>价格: %></p> -->
				        <p><a href="servlet/registSubject?subjectName=<%= d.getSubjectName() %>&count=1" class="btn btn-primary" role="button">注册</a>&nbsp;&nbsp; 
				        <a href="servlet/subjectDetail?name=<%= d.getSubjectName() %>" class="btn btn-default" role="button">查看</a></p>
				      </div>
				    </div>
	  			</div>
				<%		
					}
				%>
	    	</div>
	    
		</div>
	</div>
  </body>
</html>
