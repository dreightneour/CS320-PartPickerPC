package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CreateBuild.CreateBuildController;
import CreateBuild.CreateBuildModel;
import Parts.CpuPart;
import Parts.MotherboardPart;
import Parts.PartList;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class CreateBuildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private List<CpuPart> cpus;
	private List<MotherboardPart> mbs;

	
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
		
		req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
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
			if (username == null)
			{
				username = "the Guest";
			}
			username = username.toUpperCase();
			req.setAttribute("username", username);
			
			String low;
			String high;
			// the part search fields post
			if (req.getParameter("searchCpu") != null)
			{
				low = req.getParameter("clow");
				high = req.getParameter("chigh");
				String socketType = req.getParameter("csocketType");
				String brand = req.getParameter("cbrand");
				String series = req.getParameter("cseries");
				String cores = req.getParameter("ccores");
				if (socketType.compareTo("none") == 0)
				{
					socketType = null;
				}
				if (brand.compareTo("none") == 0)
				{
					brand = null;
				}
				if (series.compareTo("none") == 0)
				{
					series = null;
				}
				if (cores.compareTo("none") == 0)
				{
					cores = null;
				}
				
				 cpus = db.findAllCpusCrit(socketType, brand, series, null, cores, low, high);
				req.setAttribute("clist", cpus);
				req.getRequestDispatcher("/_view/cpus.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("searchMb") != null)
			{
				low = req.getParameter("mlow");
				high = req.getParameter("mhigh");
				String brand = req.getParameter("mbrand");
				if (brand.compareTo("none") == 0)
				{
					brand = null;
				}

				
				 mbs = db.findAllMbsCrit(brand, null, low, high);
				req.setAttribute("mlist", mbs);
				req.getRequestDispatcher("/_view/mbs.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("cpus") != null)
			{
				req.getRequestDispatcher("/_view/cpuCrit.jsp").forward(req, resp);
			}
			else if (req.getParameter("gpus") != null)
			{
				req.getRequestDispatcher("/_view/gpuCrit.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("mbs") != null)
			{
				req.getRequestDispatcher("/_view/mbCrit.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("rams") != null)
			{
				req.getRequestDispatcher("/_view/ramCrit.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("submitCpu") != null)
			{
				int cpunum = Integer.parseInt(req.getParameter("submitCpu"));
				System.out.println(cpunum);
					String message = controller.addPartToParts(cpus.get(cpunum));
					CpuPart baseCpu = controller.getModel().getTheBuild().getCpu();
					req.setAttribute("cpuLink", baseCpu.getUrl());
					req.setAttribute("cpuModel", baseCpu.getName());
					req.setAttribute("cpuPrice", baseCpu.getPrice());
					req.setAttribute("cpuBrand", baseCpu.getBrand());
					req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("submitMb") != null)
			{
				int mbnum = Integer.parseInt(req.getParameter("submitMb"));
				System.out.println(mbnum);
					String message = controller.addPartToParts(mbs.get(mbnum));
					MotherboardPart baseMb = controller.getModel().getTheBuild().getMb();
					req.setAttribute("motherboardLink", baseMb.getUrl());
					req.setAttribute("motherboardPrice", baseMb.getPrice());
					req.setAttribute("motherboardBrand", baseMb.getBrand());
					req.setAttribute("motherboardSocket", baseMb.getSocketType());
					req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
				
			}
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
	}
}

