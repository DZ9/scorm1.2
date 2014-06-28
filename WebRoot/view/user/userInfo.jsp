<%@ page language="java" import="java.util.*,com.idoxie.dishOL.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	ArrayList<Subject> al = (ArrayList<Subject>)request.getAttribute("list");
System.out.println(al.size());
	User u = (User)request.getAttribute("user");
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
	<link rel="stylesheet" type="text/css" href="theme/css/user/userInfo.css">
	<script type="text/javascript" src="theme/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="theme/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="theme/js/userInfo.js"></script>
<style type="text/css">
            body {
                
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }
            #class-box {
                padding: 20px;
                margin: 0px 20px 10px 20px;
                border-radius: 10px;
                vertical-align:middle;
                border:1px solid black;
                /* background: #f0e8a8;*/
            }

            #table-box {
                border-radius: 10px;
                text-align: center;
                vertical-align:middle;
                border:2px solid black;
                /* background: #f0e8a8;*/
            }

            @media (max-width: 980px) {
                /* Enable use of floated navbar text */
                .navbar-text.pull-right {
                    float: none;
                    padding-left: 5px;
                    padding-right: 5px;
                }
            }
            #courseIMG {
            	width:242px;
            	height:152px;
            	float:left;
            	margin-right:40px;
            }
            #courseIMG img {
            	width:242px;
            	height:152px;
            	
            }
        </style>
  </head>
  
  <body>
   <div id="header" class="container highlight">
  		<h1 class="text-left">欢迎光临！</h1>
  		
		<!-- 
		<form id="login" class="form-inline" role="form">
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
		 <div id="login" >
		 	欢迎你，<span id="name"><%= session.getAttribute("username") %></span>&nbsp;<span id="spcar">
		 	</span>&nbsp;<span id="list"><a href="servlet/MyAccount">个人中心</a></span>
		 	</span>&nbsp;<span id="list"><a href="view/logout.jsp">退出</a></span>
		 </div>
  	</div>
  	
  	<div id="content" class="container"> 
			<ol id="top-nav" class="breadcrumb">
			  <li><a href="servlet/showIndex">首页</a></li>
			  <li class="active">我的账户</li>
			</ol>
			
			<ul class="nav nav-tabs" id="tags">
			  <li><a href="#home" data-toggle="tab">我的账户</a></li>
			  <li><a href="#profile" data-toggle="tab">我的课程</a></li>
			</ul>
			<div class="tab-content" id="tabs">
			  <div class="tab-pane active" id="home">
				<p>用户名：<span class="info"><%= u.getUsername() %></span></p>
	  			<p>注册邮箱：<span class="info"><%= u.getEmail() %></span></p>
	  			<p>注册时间：<span class="info"><%= u.getRegisterTime() %></span></p>
			  </div>
			  <div class="tab-pane active" id="profile">
			         
			        <%! int count = 0;%>
			        <%
			        	while(it.hasNext()) {
			        		Subject d = (Subject)it.next();
			        		
			        %>
						<div class="span11" id="class-box">
                        <div class="row-fluid">
                            <div class="span6" id="courseIMG"><img src="theme/img/<%= d.getPic()%>"></div>
                            <div class="span6" id="courseDetail">
                                <p>课程名称：<%= d.getSubjectName() %></p>
                                <p>课程评分：无</p>
                                <p>我的进度：0%</p>
                                <p>我的评分：暂未评分</p>
                                <p>已观看时间：0小时</p>
                                <p>
                                    <a class="btn btn-primary" href="servlet/subjectDetail?name=<%= d.getSubjectName() %>">查看 &raquo;</a>
                                    &nbsp&nbsp&nbsp
                                    <a class="btn btn-primary" href="CourseImports/Course-1/index.html">学习 &raquo;</a>
                                   
                                </p>
                            </div>
                        </div><!--/span-->
                    </div>
			        <% 
			        	}
			        %>
			        
			        <%
			        	count =0;
			        %>
			        </tbody>
			      </table>
			  </div>
			</div>
	</div>
	
	
  </body>
</html>
