package org.crazyit.ajax.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.crazyit.ajax.service.*;
import org.crazyit.ajax.domain.*;
import org.json.*;
/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signinservlet")
public class SignInServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
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
		UserDataClass user = new UserDataClass(name,phone);
		EditUserService eus = new EditUserService();
		eus.connMysql();
		boolean isExistUser = eus.searchUser(user);
		response.setContentType("application/json;charset=GBK");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		
		if(isExistUser) {
			try {
				json.put("name", user.getName());
				json.put("phone", user.getPhone());
				System.out.println(user.getName() + "&&" + user.getPhone());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print(json);
			out.flush();
			out.close();
		}
	}

}
