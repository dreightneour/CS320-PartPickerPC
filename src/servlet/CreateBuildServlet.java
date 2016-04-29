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
			IDatabase db    = null;
			DatabaseProvider.setInstance(new DerbyDatabase());
			db = DatabaseProvider.getInstance();	
			CreateBuildModel model = new CreateBuildModel();
			CreateBuildController controller = new CreateBuildController();
			controller.setModel(model);
			
			username = (String) req.getSession().getAttribute("theUser");
			username = username.toUpperCase();
			req.setAttribute("username", username);
			
			String low;
			String high;
			// the part search fields post
			if (req.getParameter("cpu") != null)
			{
				low = req.getParameter("clow");
				high = req.getParameter("chigh");
				req.setAttribute("clist", db.findPriceRange("cpus", low, high));
				
			}
			else if (req.getParameter("gpu") != null)
			{
				low = req.getParameter("glow");
				high = req.getParameter("ghigh");
				req.setAttribute("glist", db.findPriceRange("gpus", low, high));
				
			}
			else if (req.getParameter("mb") != null)
			{
				low = req.getParameter("mlow");
				high = req.getParameter("mhigh");
				req.setAttribute("mlist", db.findPriceRange("motherboards", low, high));
				
			}
			else if (req.getParameter("ram") != null)
			{
				low = req.getParameter("rlow");
				high = req.getParameter("rhigh");
				req.setAttribute("rlist", db.findPriceRange("rams", low, high));
				
			}
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
	}
}

