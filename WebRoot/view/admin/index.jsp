<%@ page language="java" import="java.util.*,com.idoxie.dishOL.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	ArrayList<Subject> dishes = (ArrayList<Subject>)request.getAttribute("dishes");
	Iterator dishIt = dishes.iterator();
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
	<link rel="stylesheet" type="text/css" href="theme/css/admin/index.css">
	<script type="text/javascript" src="theme/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="theme/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="theme/js/adminIndex.js"></script>
	<style type="text/css">
		 #class-box {
                padding: 20px;
                margin: 0px 20px 10px 20px;
                border-radius: 10px;
                vertical-align:middle;
                border:1px solid black;
                /* background: #f0e8a8;*/
                width:796px;
                height:202px;
                margin-left:20px;
            }
         #coursePic img{
         	float:left;
         	margin-right:30px;
         	width:219px;
         	height:136px;
         }   
    </style>
  </head>
  
  <body>
    <div id="content" class="container"> 
			<ol id="top-nav" class="breadcrumb">
			  <li><a href="servlet/Admin">Home</a></li>
			  <li class="active">课程管理</li>
			</ol>
			
			<!-- 
				<ul class="nav nav-tabs" id="tags">
			  	<li><a href="#profile" data-toggle="tab" id="flag0">课程管理</a></li>
			  	<li><a href="#home" data-toggle="tab" id="flag1">添加新课件</a></li>  
			</ul>
			 -->
			<div class="tab-content" id="tabs">
			  <div class="tab-pane active" id="home">
				
			  </div>
			  
			  <div class="tab-pane active" id="profile">
				<div id="content" class="container">	
				  	<div class="row">
				  		<div id="nav-list">
					  		<div class="col-md-3 list-group nav" id="leftNav">
					  		  <a href="view/admin/dishInfo.jsp" class="list-group-item active">添加新课件</a>
					  		  <a href="servlet/Admin" onclick="flag()" class="list-group-item">全部</a>
							  <a href="servlet/Admin?type=科技" onclick="flag()" class="list-group-item">科技</a>
							  <a href="servlet/Admin?type=历史" onclick="flag()" class="list-group-item">历史</a>
							  <a href="servlet/Admin?type=人文" onclick="flag()" class="list-group-item">人文</a>
							</div>
				  		</div>
						
						 
						<div id="food-list" data-spy="scroll" data-target="#nav" class="col-md-9">
			  				<%
			  					while(dishIt.hasNext()) {
			  					  						Subject s = (Subject)dishIt.next();
			  				%>
			  					<div class="span11" id="class-box">
	                        	<div class="row-fluid">
	                            <div class="span6" id="coursePic"><img src="theme/img/<%= s.getPic() %>"></div>
	                            <div class="span6" id="courseInfo">
	                                <p>课件名称：<%= s.getSubjectName()  %></p>
	                                <p>课件评分：暂无</p>
	                                <p>总观看时间：0小时</p>
	                                <p>观看总人数：0</p>
	                                <p>
	                                    <a class="btn btn-primary" href="servlet/subjectDetail?subjectName=<%= s.getSubjectName() %>">查看 &raquo;</a>
	                
	                                    <a class="btn btn-primary" href="servlet/deleteItem?subjectName=<%= s.getSubjectName() %>">删除 &raquo;</a>
	                                </p>
	                            </div>
	                        </div><!--/span-->
	                    </div>
			  				<%
			  					}
			  				%>
				  			
						</div>
						
			  			
			  			
				    </div>
			    
			  </div>
			</div>
			
			
	</div>
  </body>
</html>
