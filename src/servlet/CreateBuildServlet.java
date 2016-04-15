package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Parts.PartList;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class CreateBuildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	

	

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/quickbuild.jsp").forward(req, resp);
	}
}

