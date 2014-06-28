package com.idoxie.dishOL.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idoxie.dishOL.model.Subject;
import com.idoxie.dishOL.service.SubjectService;

public class Admin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Admin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
		
		
		/*
		 * 得到所有dishOrder
		 */
//		SubjectService ss = new SubjectService();
//		ArrayList<Subject> orders = (ArrayList<Subject>) ss.list();
//		request.setAttribute("orders", orders);//存储所有dishOrder
		/*
		 * 得到所有dish
		 */
		
		SubjectService ss = new SubjectService();
		ArrayList<Subject> subjects = null;
		

		if(request.getParameter("type") == null) {						   //判断是否有type参数，没有返回全部
			subjects = (ArrayList<Subject>) ss.list();
		}else {
			String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"utf-8");
System.out.println("type:"+type);
			subjects = (ArrayList<Subject>) ss.listByType(type);
		}
		request.setAttribute("dishes", subjects);//存储所有dish
		
		RequestDispatcher view = 
				request.getRequestDispatcher("/view/admin/index.jsp");
		view.forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
