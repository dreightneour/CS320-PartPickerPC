package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CreateBuild.CreateBuildController;
import CreateBuild.CreateBuildModel;
import Parts.PartList;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class CreateBuildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// pulls username from session or if no user, puts guest as username in session
		if (req.getSession().getAttribute("theUser") != null)
				{
		username = (String) req.getSession().getAttribute("theUser");
		username = username.toUpperCase();
		req.setAttribute("username", username);
				}
		else
		{
			req.getSession().setAttribute("theUser", "guest");
			username = (String) req.getSession().getAttribute("theUser");
			username = username.toUpperCase();
			req.setAttribute("username", username);
		}
		
		req.getRequestDispatcher("/_view/quickbuild.jsp").forward(req, resp);
	}
	

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			CreateBuildModel model = new CreateBuildModel();
			CreateBuildController controller = new CreateBuildController();
			controller.setModel(model);
			
			username = (String) req.getSession().getAttribute("theUser");
			username = username.toUpperCase();
			req.setAttribute("username", username);
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
	}
}

