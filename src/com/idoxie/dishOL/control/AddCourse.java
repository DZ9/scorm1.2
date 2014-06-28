package com.idoxie.dishOL.control;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.idoxie.dishOL.service.SubjectService;

public class AddCourse extends HttpServlet {
	private String uploadPath="E:\\upFile\\";
    private File tempPath=new File("E:\\upFile\\temp");

	/**
	 * Constructor of the object.
	 */
	public AddCourse() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	protected String processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			    
			//创建一个上传项目工厂，并设置其缓存数据大小和临时文件保存位置
		    DiskFileItemFactory factory=new DiskFileItemFactory();
		    String path = request.getContextPath();
		    path = request.getRealPath(path);

		    int i = path.lastIndexOf("\\");
		    path = path.substring(0, i+1);
		    path = path + "course";
	System.out.println(path);
		    factory.setSizeThreshold(4096);
		    factory.setRepository(tempPath);
		    
		    //使用项目工厂创建一个ServletFileUpload对象，用于解析文件上传请求
		    //并设置可以上传的文件的最大字节数，超过会抛出异常
		    ServletFileUpload upload=new ServletFileUpload(factory);
		    upload.setSizeMax(1000000000);
		    upload.setHeaderEncoding("utf-8");
		    
		    List fileItems=null;
		    try{
		        //开始读取上传信息
		        fileItems=upload.parseRequest(request);
		        //依次处理每一个上传的文件
		        Iterator itor=fileItems.iterator();
		        //正则匹配，过滤路径取文件名
//		        String regExp=".+\\\\(.+)$";
//		        //过滤文件类型
//		        String[] errorType={".exe",".com",".cgi",".asp"};
//		        Pattern p=Pattern.compile(regExp);
		        while(itor.hasNext()){
		            FileItem item=(FileItem)itor.next();
		            
		            //忽略其他不是文件域的所有其他表单信息
//		            if(!item.isFormField()){
		                String name=item.getName();
	System.out.println(name);	                
		                long size=item.getSize();
		                if((name==null||name.equals(""))&&size==0)
		                    continue;
//		                Matcher m=p.matcher(name);
//		                boolean result=m.find();
	System.out.println("here");
		                //如果是允许上传的文件类型就执行上传操作
//		                if(result){
	//System.out.println("result");	
//		                    for(int temp=0;temp<errorType.length;temp++){
//		                        if(m.group(1).endsWith(errorType[temp])){
//		                            throw new IOException(name+":wrong type");
//		                        }
//		                    }
		                    try{
		                        //保存文件到指定的目录，如果是保存到数据库，改写这里 
	//System.out.println("uploadString:"+uploadPath+"m.group"+m.group(1));	                    	
		                           item.write(new File(path,name));
		                           return name;
		                                                                    
		                    }catch(Exception e){
		                    	e.printStackTrace();
		                    }
//		                }else{
//		                    throw new IOException("fail to upload");
//		                }
//		            }
		        }    
//		    }catch(IOException e){
//		    	e.printStackTrace();
		    }catch(FileUploadException e1){
		        e1.printStackTrace();
		    }
		    return null;   
		  } 
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String pic = request.getParameter("pic");
		String pic = new String(request.getParameter("pic").getBytes("ISO-8859-1"),"utf-8");
		System.out.println("图片："+pic);
				String subjectName = new String(request.getParameter("subjectName").getBytes("ISO-8859-1"),"utf-8");
				String subjectBagName = new String(request.getParameter("subjectBagName").getBytes("ISO-8859-1"),"utf-8");
				String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"utf-8");
				String desc = new String(request.getParameter("desc").getBytes("ISO-8859-1"),"utf-8");
				SubjectService ds = new SubjectService();
				
//				if(ds.isExist(dishName)) {
//		System.out.println("更新菜品");
//					ds.updateDish(dishName, price, type, 0, desc, pic);
//				}else {
		System.out.println("添加菜品");
					ds.addSubject(subjectName, type, 0, desc, pic, subjectBagName);
//				}
				UploadImg ui = new UploadImg();
				processRequest(request,response);
				ui.processRequest(request, response);
				RequestDispatcher view =
						request.getRequestDispatcher("/view/admin/addSuccess.jsp");
				view.forward(request, response);
//				processRequest(request,response);
			}
//		processRequest(request,response);
	


	
    /**
     * 初始化Servlet，确保需要使用的目录都被建立<br>
     * @throws javax.servlet.ServletException
     */
    
    @Override
    public void init() throws ServletException{
        if(!new File(uploadPath).isDirectory())
            new File(uploadPath).mkdir();
        if(!tempPath.isDirectory())
            tempPath.mkdir();
    }
}
