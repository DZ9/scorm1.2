package com.idoxie.dishOL.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.idoxie.dishOL.model.Subject;
import com.idoxie.dishOL.model.User;
import com.idoxie.dishOL.service.UserService;

public class MyAccount extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MyAccount() {
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
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("username");
System.out.println("userName:"+userName);
		if(userName == null) {
			RequestDispatcher view =  
					request.getRequestDispatcher("/");
			view.forward(request, response);
		}else {
			UserService us = new UserService();
			ArrayList<Subject> list = (ArrayList<Subject>) us.listSubject(userName);
			User u =  us.getUser(userName);
System.out.println("list:"+list.size());
System.out.println("user:"+u.getUsername());
			request.setAttribute("user", u);
			request.setAttribute("list", list);
			RequestDispatcher view =
					request.getRequestDispatcher("/view/user/userInfo.jsp");
			
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
