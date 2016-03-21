package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partPickerPC.Build;
import partPickerPC.CpuPart;
import partPickerPC.GpuPart;
import partPickerPC.MotherboardPart;
import partPickerPC.QuickBuildController;
import partPickerPC.QuickBuildModel;
import partPickerPC.RamPart;

public class QuickBuildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	int counter = 0;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		username = (String) req.getSession().getAttribute("theUser");
		username = username.toUpperCase();
		req.setAttribute("username", username);
		
		req.getRequestDispatcher("/_view/quickbuild.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		QuickBuildModel model = new QuickBuildModel();
		QuickBuildController controller = new QuickBuildController();
		controller.setModel(model);
		double price;
		username = (String) req.getSession().getAttribute("theUser");
		username = username.toUpperCase();
		req.setAttribute("username", username);

			if (req.getParameter("cheap") != null)
			{
			Build cheapBuild = controller.giveCheapest();
			price = cheapBuild.getPrice();
			CpuPart cpu = (CpuPart) cheapBuild.getTheParts().get(0);
			MotherboardPart motherboard = (MotherboardPart) cheapBuild.getTheParts().get(1);
			GpuPart gpu = (GpuPart) cheapBuild.getTheParts().get(2);
			RamPart ram = (RamPart) cheapBuild.getTheParts().get(3);
			// set cpu stuff
			req.setAttribute("cpuModel", cpu.getName());
			req.setAttribute("cpuPrice", cpu.getPrice());
			req.setAttribute("cpuBrand", cpu.getBrand());
			req.setAttribute("cpuSeries", cpu.getSeries());
			req.setAttribute("cpuSocket", cpu.getSocketType());
			req.setAttribute("cpuFrequency", cpu.getFrequency());
			req.setAttribute("cpuCores", cpu.getCores());
			 //set motherboard stuff
			req.setAttribute("motherboardModel", motherboard.getModel());
			req.setAttribute("motherboardPrice", motherboard.getPrice());
			req.setAttribute("motherboardBrand", motherboard.getBrand());
			req.setAttribute("motherboardSocket", motherboard.getSocketType());
			// set gpu stuff
			req.setAttribute("gpuModel", gpu.getModel());
			req.setAttribute("gpuPrice", gpu.getPrice());
			req.setAttribute("gpuBrand", gpu.getBrand());
			req.setAttribute("gpuSeries", gpu.getGpuBase());
			req.setAttribute("gpuSlot", gpu.getSlotType());
			req.setAttribute("gpuMemory", gpu.getMemorySize());
			// set ram stuff
			req.setAttribute("ramModel", ram.getModel());
			req.setAttribute("ramPrice", ram.getPrice());
			req.setAttribute("ramBrand", ram.getBrand());
			req.setAttribute("ramSeries", ram.getSeries());
			req.setAttribute("ramType", ram.getType());
			req.setAttribute("ramCapacity", ram.getCapacity());
			req.setAttribute("ramMulti", ram.getMultichannelType());
			
			// set total price
			req.setAttribute("total", cheapBuild.getPrice());
		
		
			}
			else if  (req.getParameter("expensive") != null)
			{
				Build expensiveBuild = controller.giveExpensive();
				price = expensiveBuild.getPrice();
				CpuPart cpu = (CpuPart) expensiveBuild.getTheParts().get(0);
				MotherboardPart motherboard = (MotherboardPart) expensiveBuild.getTheParts().get(1);
				GpuPart gpu = (GpuPart) expensiveBuild.getTheParts().get(2);
				RamPart ram = (RamPart) expensiveBuild.getTheParts().get(3);
				// set cpu stuff
				req.setAttribute("cpuModel", cpu.getName());
				req.setAttribute("cpuPrice", cpu.getPrice());
				req.setAttribute("cpuBrand", cpu.getBrand());
				req.setAttribute("cpuSeries", cpu.getSeries());
				req.setAttribute("cpuSocket", cpu.getSocketType());
				req.setAttribute("cpuFrequency", cpu.getFrequency());
				req.setAttribute("cpuCores", cpu.getCores());
				 //set motherboard stuff
				req.setAttribute("motherboardModel", motherboard.getModel());
				req.setAttribute("motherboardPrice", motherboard.getPrice());
				req.setAttribute("motherboardBrand", motherboard.getBrand());
				req.setAttribute("motherboardSocket", motherboard.getSocketType());
				// set gpu stuff
				req.setAttribute("gpuModel", gpu.getModel());
				req.setAttribute("gpuPrice", gpu.getPrice());
				req.setAttribute("gpuBrand", gpu.getBrand());
				req.setAttribute("gpuSeries", gpu.getGpuBase());
				req.setAttribute("gpuSlot", gpu.getSlotType());
				req.setAttribute("gpuMemory", gpu.getMemorySize());
				// set ram stuff
				req.setAttribute("ramModel", ram.getModel());
				req.setAttribute("ramPrice", ram.getPrice());
				req.setAttribute("ramBrand", ram.getBrand());
				req.setAttribute("ramSeries", ram.getSeries());
				req.setAttribute("ramType", ram.getType());
				req.setAttribute("ramCapacity", ram.getCapacity());
				req.setAttribute("ramMulti", ram.getMultichannelType());
				
				// set total price
				req.setAttribute("total", expensiveBuild.getPrice());
			}
			else if  (req.getParameter("anotherbuild") != null)
			{
				Build anotherBuild = controller.giveCompatibleBuild(counter);
				price = anotherBuild.getPrice();
				CpuPart cpu = (CpuPart) anotherBuild.getTheParts().get(0);
				MotherboardPart motherboard = (MotherboardPart) anotherBuild.getTheParts().get(1);
				GpuPart gpu = (GpuPart) anotherBuild.getTheParts().get(2);
				RamPart ram = (RamPart) anotherBuild.getTheParts().get(3);
				// set cpu stuff
				req.setAttribute("cpuModel", cpu.getName());
				req.setAttribute("cpuPrice", cpu.getPrice());
				req.setAttribute("cpuBrand", cpu.getBrand());
				req.setAttribute("cpuSeries", cpu.getSeries());
				req.setAttribute("cpuSocket", cpu.getSocketType());
				req.setAttribute("cpuFrequency", cpu.getFrequency());
				req.setAttribute("cpuCores", cpu.getCores());
				 //set motherboard stuff
				req.setAttribute("motherboardModel", motherboard.getModel());
				req.setAttribute("motherboardPrice", motherboard.getPrice());
				req.setAttribute("motherboardBrand", motherboard.getBrand());
				req.setAttribute("motherboardSocket", motherboard.getSocketType());
				// set gpu stuff
				req.setAttribute("gpuModel", gpu.getModel());
				req.setAttribute("gpuPrice", gpu.getPrice());
				req.setAttribute("gpuBrand", gpu.getBrand());
				req.setAttribute("gpuSeries", gpu.getGpuBase());
				req.setAttribute("gpuSlot", gpu.getSlotType());
				req.setAttribute("gpuMemory", gpu.getMemorySize());
				// set ram stuff
				req.setAttribute("ramModel", ram.getModel());
				req.setAttribute("ramPrice", ram.getPrice());
				req.setAttribute("ramBrand", ram.getBrand());
				req.setAttribute("ramSeries", ram.getSeries());
				req.setAttribute("ramType", ram.getType());
				req.setAttribute("ramCapacity", ram.getCapacity());
				req.setAttribute("ramMulti", ram.getMultichannelType());
				
				// set total price
				req.setAttribute("total", anotherBuild.getPrice());
				counter++;
			}
			
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/quickbuild.jsp").forward(req, resp);
	}
}
