package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Parts.CpuPart;
import Parts.GpuPart;
import Parts.MotherboardPart;
import Parts.RamPart;
import Parts.StoragePart;
import QuickBuild.QuickBuildController;
import QuickBuild.QuickBuildModel;
import partPickerPC.Build;

public class QuickBuildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private int counter = 0;
	private Build theBuild;
	private double price;

	
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
		QuickBuildModel model = new QuickBuildModel();
		QuickBuildController controller = new QuickBuildController();
		controller.setModel(model);
		username = (String) req.getSession().getAttribute("theUser");
		username = username.toUpperCase();
		req.setAttribute("username", username); // gets most expensive or cheapest from controller
			if (req.getParameter("cheap") != null)
			{
			 theBuild = controller.giveCheapest();
			}
			else if  (req.getParameter("expensive") != null)
			{
			 theBuild = controller.giveExpensive();
			}

			price = theBuild.getPrice();
			CpuPart cpu =  theBuild.getCpu();
			MotherboardPart motherboard = theBuild.getMb();
			GpuPart gpu =  theBuild.getGpu();
			RamPart ram = theBuild.getRam();
			StoragePart storage = theBuild.getStorage();
			// set cpu stuff
			req.setAttribute("cpuLink", cpu.getUrl());
			req.setAttribute("cpuModel", cpu.getModel());
			req.setAttribute("cpuPrice", cpu.getPrice());
			req.setAttribute("cpuBrand", cpu.getBrand());
			req.setAttribute("cpuSeries", cpu.getSeries());
			req.setAttribute("cpuSocket", cpu.getSocketType());
			req.setAttribute("cpuFrequency", cpu.getFrequency());
			req.setAttribute("cpuCores", cpu.getCores());
			 //set motherboard stuff
			req.setAttribute("motherboardLink", motherboard.getUrl());
			req.setAttribute("motherboardModel", motherboard.getModel());
			req.setAttribute("motherboardPrice", motherboard.getPrice());
			req.setAttribute("motherboardBrand", motherboard.getBrand());
			req.setAttribute("motherboardSocket", motherboard.getSocketType());
			// set gpu stuff
			req.setAttribute("gpuLink", gpu.getUrl());
			req.setAttribute("gpuModel", gpu.getModel());
			req.setAttribute("gpuPrice", gpu.getPrice());
			req.setAttribute("gpuBrand", gpu.getBrand());
			req.setAttribute("gpuSeries", gpu.getGpuBase());
			req.setAttribute("gpuSlot", gpu.getSlotType());
			req.setAttribute("gpuMemory", gpu.getMemorySize());
			// set ram stuff
			req.setAttribute("ramLink", ram.getUrl());
			req.setAttribute("ramModel", ram.getModel());
			req.setAttribute("ramPrice", ram.getPrice());
			req.setAttribute("ramBrand", ram.getBrand());
			req.setAttribute("ramSeries", ram.getSeries());
			req.setAttribute("ramType", ram.getType());
			req.setAttribute("ramCapacity", ram.getCapacity());
			req.setAttribute("ramMulti", ram.getMultichannelType());
			
			//set storage stuff
			if (storage != null)
			{
			req.setAttribute("storageLink", storage.getUrl());
			req.setAttribute("storageModel", storage.getModel());
			req.setAttribute("storageBrand", storage.getBrand());
			req.setAttribute("storagePrice", storage.getPrice());
			req.setAttribute("storageDataspeed", storage.getdataSpeed());
			req.setAttribute("storageCapacity", storage.getCapacity());
			}
			
			
			// set total price
			req.setAttribute("total", theBuild.getPrice());
			
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/quickbuild.jsp").forward(req, resp);
	}
}
