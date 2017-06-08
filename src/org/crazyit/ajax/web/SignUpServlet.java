package org.crazyit.ajax.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.crazyit.ajax.domain.*;
import org.crazyit.ajax.service.*;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String)request.getParameter("name");
		String phone = (String)request.getParameter("phone");
		UserDataClass user = new UserDataClass();
		user.setUser(name, phone);
		EditUserService eus = new EditUserService();
		eus.connMysql();
		if(eus.insertUser(user)) {
			response.sendRedirect("index.html");
			System.out.println("注册成功");
			return;
		}else{
			System.out.println("未成功");
		}
	}

}
