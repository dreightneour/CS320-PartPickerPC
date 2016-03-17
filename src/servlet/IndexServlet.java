package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import edu.ycp.cs320.lab03.controller.AddNumbersController;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> userpassword = new HashMap<String, String>();
	private int loginvalue;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		userpassword.put("hunter", "blue");
		userpassword.put("robert", "red");
		userpassword.put("dan", "green");
		userpassword.put("drevon", "orange");
		System.out.println("In the Index servlet");
		
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		boolean userVerify = false;
		String errorMessage = null;
		String result = null;
		
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if (req.getParameter("login") != null)
			{
			if (username == null || password == null && loginvalue != 0 || username == "" || password == "") {
				loginvalue = 0;
				System.out.println("notting");
			}
			else if (userpassword.containsKey(username))
				{
					if (userpassword.get(username).compareTo(password) == 0)
					{
						loginvalue = 1;
					}
					else
					{
						loginvalue = 2;
					}
					
				}
				
		
			
		 
		
		// Add parameters as request attributes
		//req.setAttribute("username", "username");
		//req.setAttribute("password", "password");
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		//req.setAttribute("result", result);
		if (loginvalue == 1)
		{
			result = "success";
			//req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
			resp.sendRedirect("/lol/addNumbers");
		}
		else if (loginvalue == 2)
		{
			result = "failure";
			
		}
		else if (loginvalue == 0)
		{
			result = "please enter a username or password";
		}
		req.setAttribute("userVerify", result);
		
		
			}
			else if  (req.getParameter("test") != null)
			{
				req.setAttribute("userVerify", "YOO DIFFERENT METHOD");
			}
			
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
}
