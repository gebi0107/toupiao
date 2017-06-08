package org.crazyit.ajax.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;
//import org.json.*;

import org.crazyit.ajax.domain.*;

@WebServlet(urlPatterns={"/chooseDate"})

public class ChooseDateServlet extends HttpServlet {
	
		DateClass dc = new DateClass();
	
		public void service(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
			
				String valueStr = (String)request.getParameter("value");
				
				dc.count(valueStr);
				response.setContentType("text/html;charset=GBK");
				PrintWriter out = response.getWriter();
				out.println("Thursday" + dc.getThursday() + "<br />");
				out.println("Friday" + dc.getFriday());
			}
	}