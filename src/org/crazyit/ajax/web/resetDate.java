package org.crazyit.ajax.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.crazyit.ajax.domain.*;

import org.json.*;
/**
 * Servlet implementation class resetDate
 */
@WebServlet(name = "ResetDateServlet", urlPatterns = { "/resetDate" })
public class resetDate extends HttpServlet {
	
	DateClass dc = new DateClass();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dc.reset();
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("thursday", dc.getThursday());
			jsonObj.put("friday", dc.getFriday());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println(jsonObj);
		//out.println("Thursday=" + dc.getThursday());
		//out.println("<br />Friday=" + dc.getFriday());
	}

}
