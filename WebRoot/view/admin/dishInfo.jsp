<%@ page language="java" import="java.util.*,com.idoxie.dishOL.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String name = null;
	if(request.getAttribute("name") != null) {
		name = (String)request.getAttribute("name");
	}
	
	Subject d = null;
	if(request.getAttribute("dish") != null) {
		d = (Subject)request.getAttribute("dish");
	}else {
		d = new Subject();
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dishInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="theme/css/bootstrap-3.1.0.min.css">
	<link rel="stylesheet" type="text/css" href="theme/css/admin/dishInfo.css">
	<script type="text/javascript" src="theme/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="theme/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="theme/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="theme/js/uploadImg.js"></script>
	<script type="text/javascript" src="theme/js/dishInfo.js"></script>
	<script type="text/javascript">
	function ajaxFileUpload()
	{
	   $.ajaxFileUpload
	      (
	        {
	             url:'servlet/UploadImg', //你处理上传文件的服务端
				 secureuri:false,
				 fileElementId:'doc',
				 dataType: 'json',
	             success: function (data)
	                   {
	                     alert("上传成功");
	                   }
	                }
	          )
	
	        return false;
	  } 
	</script>
  </head>
  
  <body>
    <div id="content" class="container"> 
			<ol id="top-nav" class="breadcrumb">
			  <li><a href="servlet/Admin">Home</a></li>
			  <li class="active">课程管理</li>
			</ol>
	</div>
	
	<div class="container">
		
		
		<div id="info" class="col-md-12">
			<form id="upload" class="form-horizontal" role="form" action="servlet/UploadImg" method="post">
				<div id="pic" class="col-md-3">
					<p>
					<div id="localImag"><img id="preview" width=300px height=200px style="diplay:block" /></div>
					</p>
					<input type=file name="pic" id="doc" onchange="javascript:setImagePreview();" value="<%= d.getPic() %>"> 
					<span><button id="upimg" type="button" onclick="return ajaxFileUpload();" class="btn btn-success col-sm-offset-1">上传图片</button></span>
			 	</div>
			</form>
			
			<form id="register" class="form-horizontal" role="form" action="servlet/AddCourse" method="post">
			 
			 <div class="col-md-3 form-group" style="display:none">
					<input type=text name="pic" id="img" value="<%= d.getPic() %>">
					<span><button id="upbtn" type="submit" class="btn btn-success col-sm-offset-1">上传</button></span>
			 </div>
			 	
			  <div class="form-group prop" >
			    <label for="exampleInputEmail2" class="col-sm-2 control-label">课程名：</label>
			    <div class="col-sm-5">
			      <input type="text" name="subjectName" class="form-control" id="dishName" placeholder="请输入课程名" value="<%= d.getSubjectName() %>">
			      <span id="derror" class="error" style="display:none">请输入课程名</span>
			    </div>
			  </div>
			  
			  <div class="form-group prop" >
			    <label for="exampleInputEmail2" class="col-sm-2 control-label">选择课件：</label>
			    <div class="col-sm-5">
			      <input type="file" name="subjectBagName">
			    </div>
			  </div>
			  
			  <div class="form-group prop">
			    <label for="exampleInputEmail2" class="col-sm-2 control-label">选择类别：</label>
			    <div class="col-sm-5">
			      <select class="form-control" name="type" value="<%= d.getType() %>">
				  <option>科技</option>
				  <option>历史</option>
				  <option>人文</option>
				  </select>
			    </div>
			  </div>
			  
			  
			  <div class="form-group prop" id="desc">
			    <label for="exampleInputEmail2" class="col-sm-2 control-label">简介：</label>
			    <div class="col-sm-5">
					<textarea class="form-control" rows="3" name="desc" id="textarea"><%= d.getDescription() %></textarea>
					<span id="terror" class="error" style="display:none">请输入简介</span>
				</select>
			    </div>
			  </div>
			  <br><br>
			  
			  <button id="sub" type="submit" class="btn btn-primary col-sm-offset-3">添加</button>
			</form>	
		</div>
		
	</div>
	
  </body>
</html>
