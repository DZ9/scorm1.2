package com.idoxie.dishOL.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.idoxie.dishOL.service.UserService;

public class Register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Register() {
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
		String stuNum = request.getParameter("stuNum");
		String major = new String(request.getParameter("major").getBytes("ISO-8859-1"),"utf-8");
		String userName = new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8");
System.out.println(userName);
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Date createTime = new Date();
		
		UserService us = new UserService();
		if(us.isExist(userName)) {
			RequestDispatcher view = 
					request.getRequestDispatcher("/view/user/rerror.jsp");
			view.forward(request, response);
		}else {
			us.addUser(stuNum,userName, password, email, createTime,major);
			HttpSession session = request.getSession();
			session.setAttribute("username", userName);
			session.setMaxInactiveInterval(6000);
			RequestDispatcher view =
					request.getRequestDispatcher("/servlet/showIndex");
			view.forward(request, response);
		}
		
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
