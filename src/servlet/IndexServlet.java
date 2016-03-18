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
			if (username == null || password == null || username == "" || password == "") {
				loginvalue = 0;
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
			else
			{
				loginvalue = 2;
			}
				
		
			
		 
		
		// Add parameters as request attributes
		//req.setAttribute("username", "username");
		//req.setAttribute("password", "password");
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		//req.setAttribute("result", result);
		if (loginvalue == 1)
		{
			System.out.println("1" + loginvalue);
			result = "success";
			req.setAttribute("loggedin", true);
			resp.sendRedirect("/ppc/homepage");
		}
		else if (loginvalue == 2)
		{
			System.out.println("2" + loginvalue);
			result = "failure";
			req.setAttribute("loggedin", false);
			
		}
		else if (loginvalue == 0)
		{
			System.out.println("000" + loginvalue);
			result = "please enter a username or password";
			req.setAttribute("hiddenornah", "none");
		}
		System.out.println("" + loginvalue);
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
