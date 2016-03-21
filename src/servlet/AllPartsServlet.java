package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		username = (String) req.getSession().getAttribute("theUser");
		username = username.toUpperCase();
		req.setAttribute("username", username);
		
		PartList parts = new PartList();
		for (int i = 0; i < parts.getCpus().size(); i++)
		{
			// set cpu stuff
			req.setAttribute("cpuModel" + i, parts.getCpus().get(i).getName());
			req.setAttribute("cpuPrice" + i, parts.getCpus().get(i).getPrice());
			req.setAttribute("cpuBrand" + i, parts.getCpus().get(i).getBrand());
			req.setAttribute("cpuSeries" + i, parts.getCpus().get(i).getSeries());
			req.setAttribute("cpuSocket" + i, parts.getCpus().get(i).getSocketType());
			req.setAttribute("cpuFrequency" + i, parts.getCpus().get(i).getFrequency());
			req.setAttribute("cpuCores" + i, parts.getCpus().get(i).getCores());
		}
		req.getRequestDispatcher("/_view/allparts.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/quickbuild.jsp").forward(req, resp);
	}
}
