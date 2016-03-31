package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.HttpConnection.Output;

import partPickerPC.Build;
import partPickerPC.CpuPart;
import partPickerPC.GpuPart;
import partPickerPC.MotherboardPart;
import partPickerPC.PartList;
import partPickerPC.QuickBuildController;
import partPickerPC.QuickBuildModel;
import partPickerPC.RamPart;

public class AllPartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//username = (String) req.getSession().getAttribute("theUser");
		//username = username.toUpperCase();
		//req.setAttribute("username", username);
		
		PartList parts = new PartList();
		req.setAttribute("cpus", parts.getCpus());
		req.setAttribute("motherboards", parts.getMotherboards());
		req.setAttribute("gpus", parts.getGpus());
		req.setAttribute("rams", parts.getRams());

		req.getRequestDispatcher("/_view/allparts.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/quickbuild.jsp").forward(req, resp);
	}
}
