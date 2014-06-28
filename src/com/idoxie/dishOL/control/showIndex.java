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
import com.idoxie.dishOL.service.SubjectService;

public class showIndex extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public showIndex() {
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
		if(userName == null) {
			RequestDispatcher view =  
					request.getRequestDispatcher("/");
			view.forward(request, response);
		}else {
//System.out.println("session:"+request.getSession(false));
			request.setCharacterEncoding("utf-8");
			String type = request.getParameter("type");
			//String type = request.getParameter("type");
System.out.println("用户首页type第一次："+type);
			ArrayList<Subject> al = null;
			SubjectService ds = new SubjectService();
			if(type == null) {
				al = (ArrayList<Subject>) ds.list();
			}else {
				type=new String(request.getParameter("type").getBytes("ISO-8859-1"),"utf-8");
				al = (ArrayList<Subject>) ds.listByType(type);
System.out.println(al.size());
			}
			request.setAttribute("al", al);
			RequestDispatcher view =  
					request.getRequestDispatcher("/view/user/index.jsp");
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
