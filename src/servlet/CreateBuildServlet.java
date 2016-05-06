package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CreateBuild.CreateBuildController;
import CreateBuild.CreateBuildModel;
import Parts.CpuPart;
import Parts.GpuPart;
import Parts.MotherboardPart;
import Parts.PartList;
import Parts.RamPart;
import Parts.StoragePart;
import partPickerPC.NewBuild;
import partPickerPC.Search;
import partPickerPC.User;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class CreateBuildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private List<CpuPart> cpus;
	private List<MotherboardPart> mbs;
	private String buildName;
	private List<GpuPart> gpus;
	private List<RamPart> rams;
	private List<StoragePart> ssds;
	private List<NewBuild> builds;
	private int build_id;
	CreateBuildModel model = new CreateBuildModel();
	CreateBuildController controller = new CreateBuildController();
	

	
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
		
		if (req.getSession().getAttribute("cpubuild") != null)
				{
				req.setAttribute("cpubuild", req.getSession().getAttribute("cpubuild"));
				}
		if (req.getSession().getAttribute("mbbuild") != null)
		{
		req.setAttribute("mbbuild", req.getSession().getAttribute("mbbuild"));
		}
		if (req.getSession().getAttribute("gpubuild") != null)
		{
		req.setAttribute("gpubuild", req.getSession().getAttribute("gpubuild"));
		}
		if (req.getSession().getAttribute("rambuild") != null)
		{
		req.setAttribute("rambuild", req.getSession().getAttribute("rambuild"));
		}
		if (req.getSession().getAttribute("ssdbuild") != null)
		{
		req.setAttribute("ssdbuild", req.getSession().getAttribute("ssdbuild"));
		}
		
		req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
	}
	

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			IDatabase db    = null;
			DatabaseProvider.setInstance(new DerbyDatabase());
			db = DatabaseProvider.getInstance();	
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
				if(low.equals(""))
				{
					low = "1";
				}
				if(high.equals(""))
				{
					high = "999999";
				}
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
				if(low.equals(""))
				{
					low = "1";
				}
				if(high.equals(""))
				{
					high = "999999";
				}
				String brand = req.getParameter("mbrand");
				if (brand.compareTo("none") == 0)
				{
					brand = null;
				}

				
				 mbs = db.findAllMbsCrit(brand, null, low, high);
				req.setAttribute("mlist", mbs);
				req.getRequestDispatcher("/_view/mbs.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("searchGpu") != null)
			{
				low = req.getParameter("glow");
				high = req.getParameter("ghigh");
				if(low.equals(""))
				{
					low = "1";
				}
				if(high.equals(""))
				{
					high = "999999";
				}
				String memorySize = req.getParameter("gmemorysize");
				String brand = req.getParameter("gbrand");
				if (brand.compareTo("none") == 0)
				{
					brand = null;
				}
				if (memorySize.compareTo("none") == 0)
				{
					memorySize = null;
				}

				
				 gpus = db.findAllGpusCrit(brand, null, null, memorySize, low, high);
				req.setAttribute("glist", gpus);
				req.getRequestDispatcher("/_view/gpus.jsp").forward(req, resp);
			}
			
			else if (req.getParameter("searchRam") != null)
			{
				low = req.getParameter("rlow");
				high = req.getParameter("rhigh");
				if(low.equals(""))
				{
					low = "1";
				}
				if(high.equals(""))
				{
					high = "999999";
				}
				String type = req.getParameter("rtype");
				String brand = req.getParameter("rbrand");
				if (brand.compareTo("none") == 0)
				{
					brand = null;
				}
				if (type.compareTo("none") == 0)
				{
					type = null;
				}

				
				 rams = db.findAllRamsCrit(brand, type, null, null, low, high);
				req.setAttribute("rlist", rams);
				req.getRequestDispatcher("/_view/rams.jsp").forward(req, resp);
			}
			else if (req.getParameter("searchStorage") != null)
			{
				low = req.getParameter("slow");
				high = req.getParameter("shigh");
				if(low.equals(""))
				{
					low = "1";
				}
				if(high.equals(""))
				{
					high = "999999";
				}
				String brand = req.getParameter("sbrand");
				if (brand.compareTo("none") == 0)
				{
					brand = null;
				}

				
				ssds = db.findAllStorageCrit(brand, null, low, high);
				req.setAttribute("slist", ssds);
				req.getRequestDispatcher("/_view/storages.jsp").forward(req, resp);
			}
			else if (req.getParameter("cpus") != null)
			{
				List<CpuPart> cpuList = db.findAllCpus();
				Search search = new Search();
				DerbyDatabase derby = new DerbyDatabase();
				if(req.getParameter("priceUpd") != null)
				{
					for(int i = 0; i < cpuList.size(); i++)
					{
						//cpuList.get(i).setPrice(Search.getPrice(cpuList.get(i).getUrl()));
						double price = search.getPrice(cpuList.get(i).getUrl());
						try {
							derby.writeCpuPrice(price, cpuList.get(i).getSeries());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				req.getRequestDispatcher("/_view/cpuCrit.jsp").forward(req, resp);

				
			}
			else if (req.getParameter("gpus") != null)
			{
				List<GpuPart> gpuList = db.findAllGpus();
				Search search = new Search();
				DerbyDatabase derby = new DerbyDatabase();
				if(req.getParameter("priceUpd") != null)
				{
					for(int i = 0; i < gpuList.size(); i++)
					{
						//cpuList.get(i).setPrice(Search.getPrice(cpuList.get(i).getUrl()));
						double price = search.getPrice(gpuList.get(i).getUrl());
						try {
							derby.writeGpuPrice(price, gpuList.get(i).getModel());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				req.getRequestDispatcher("/_view/gpuCrit.jsp").forward(req, resp);
	
				
			}
			else if (req.getParameter("mbs") != null)
			{
				List<MotherboardPart> motherList = db.findAllMobos();
				Search search = new Search();
				DerbyDatabase derby = new DerbyDatabase();
				if(req.getParameter("priceUpd") != null)
				{
					for(int i = 0; i < motherList.size(); i++)
					{
						//cpuList.get(i).setPrice(Search.getPrice(cpuList.get(i).getUrl()));
						double price = search.getPrice(motherList.get(i).getUrl());
						try {
							derby.writeMotherPrice(price, motherList.get(i).getModel());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				req.getRequestDispatcher("/_view/mbCrit.jsp").forward(req, resp);
	
				
			}
			else if (req.getParameter("rams") != null)
			{
				List<RamPart> ramList = db.findAllRam();
				Search search = new Search();
				DerbyDatabase derby = new DerbyDatabase();
				if(req.getParameter("priceUpd") != null)
				{
					for(int i = 0; i < ramList.size(); i++)
					{
						//cpuList.get(i).setPrice(Search.getPrice(cpuList.get(i).getUrl()));
						double price = search.getPrice(ramList.get(i).getUrl());
						try {
							derby.writeRamPrice(price, ramList.get(i).getModel());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				req.getRequestDispatcher("/_view/ramCrit.jsp").forward(req, resp);
				
				
			}
			else if (req.getParameter("storages") != null)
			{
				List<StoragePart> ssdList = db.findAllStorage();
				Search search = new Search();
				DerbyDatabase derby = new DerbyDatabase();
				if(req.getParameter("priceUpd") != null)
				{
					for(int i = 0; i < ssdList.size(); i++)
					{
						//cpuList.get(i).setPrice(Search.getPrice(cpuList.get(i).getUrl()));
						double price = search.getPrice(ssdList.get(i).getUrl());
						try {
							derby.writeStoragePrice(price, ssdList.get(i).getModel());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				req.getRequestDispatcher("/_view/storageCrit.jsp").forward(req, resp);
				
				
			}
			else if (req.getParameter("submitCpu") != null)
			{
				int cpunum = Integer.parseInt(req.getParameter("submitCpu"));
				System.out.println(cpunum);
					String message = controller.addPartToParts(cpus.get(cpunum));
					CpuPart baseCpu = controller.getModel().getTheBuild().getCpu();
					req.getSession().setAttribute("cpubuild", cpus.get(cpunum));
					
					try {
						db.writeCpuBuild(cpus.get(cpunum).getSeries(), buildName);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//TODO: add Update for the cpu piece of build, 
					//TODO: needs to know which build id it is working with
					
					//req.setAttribute("cpuLink", baseCpu.getUrl());
					//req.setAttribute("cpuModel", baseCpu.getName());
					//req.setAttribute("cpuPrice", baseCpu.getPrice());
					//req.setAttribute("cpuBrand", baseCpu.getBrand());
					//req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("submitMb") != null)
			{
				int mbnum = Integer.parseInt(req.getParameter("submitMb"));
				System.out.println(mbnum);
					String message = controller.addPartToParts(mbs.get(mbnum));
					MotherboardPart baseMb = controller.getModel().getTheBuild().getMb();
					req.getSession().setAttribute("mbbuild", mbs.get(mbnum));
					String model = mbs.get(mbnum).getModel();
					try {
						db.writeMotherBuild(model, req.getParameter("buildName"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//req.setAttribute("motherboardLink", baseMb.getUrl());
					//req.setAttribute("motherboardPrice", baseMb.getPrice());
					//req.setAttribute("motherboardBrand", baseMb.getBrand());
					//req.setAttribute("motherboardSocket", baseMb.getSocketType());
					//req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("submitGpu") != null)
			{
				int gpunum = Integer.parseInt(req.getParameter("submitGpu"));
				System.out.println(gpunum);
					String message = controller.addPartToParts(gpus.get(gpunum));
					GpuPart baseGpu = controller.getModel().getTheBuild().getGpu();
					req.getSession().setAttribute("gpubuild", gpus.get(gpunum));
					String model = gpus.get(gpunum).getModel();
					try {
						db.writeGpuBuild(model, req.getParameter("buildName"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//req.setAttribute("cpuLink", baseCpu.getUrl());
					//req.setAttribute("cpuModel", baseCpu.getName());
					//req.setAttribute("cpuPrice", baseCpu.getPrice());
					//req.setAttribute("cpuBrand", baseCpu.getBrand());
					//req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
				
			}
			else if (req.getParameter("submitRam") != null)
			{
				int ramnum = Integer.parseInt(req.getParameter("submitRam"));
				System.out.println(ramnum);
					String message = controller.addPartToParts(rams.get(ramnum));
					RamPart baseRam = controller.getModel().getTheBuild().getRam();
					req.getSession().setAttribute("rambuild", rams.get(ramnum));
					
					try {
						db.writeRamBuild(rams.get(ramnum).getModel(), buildName);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//req.setAttribute("cpuLink", baseCpu.getUrl());
					//req.setAttribute("cpuModel", baseCpu.getName());
					//req.setAttribute("cpuPrice", baseCpu.getPrice());
					//req.setAttribute("cpuBrand", baseCpu.getBrand());
					//req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
					//
			}
			else if (req.getParameter("submitStorage") != null)
			{
				int ssdnum = Integer.parseInt(req.getParameter("submitStorage"));
				System.out.println(ssdnum);
					String message = controller.addPartToParts(ssds.get(ssdnum));
					RamPart baseRam = controller.getModel().getTheBuild().getRam();
					req.getSession().setAttribute("ssdbuild", ssds.get(ssdnum));
					String model = ssds.get(ssdnum).getModel();
					try {
						db.writeStorageBuild(model, buildName);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//req.setAttribute("cpuLink", baseCpu.getUrl());
					//req.setAttribute("cpuModel", baseCpu.getName());
					//req.setAttribute("cpuPrice", baseCpu.getPrice());
					//req.setAttribute("cpuBrand", baseCpu.getBrand());
					//req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
				
			}
			else if(req.getParameter("update") != null)
			{
				
			}
			else if(req.getParameter("newB") != null)
			{
				
			}
			else if(req.getParameter("saveB") != null)
			{
				if(req.getParameter("buildName") != null){
					
					User u = db.findUserAlone(username);
					
					
					String buildName = req.getParameter("buildName");
					this.buildName = buildName;
					List<NewBuild> build = new ArrayList<NewBuild>();
					try {
						db.insertBuild(u.getName(), buildName);
						 build = db.findAllBuilds();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					build = new ArrayList<NewBuild>();
				}else{
					req.setAttribute("userVerify", "Please enter a name for your Build.");
				}
				
			}
			else if(req.getParameter("loadB") != null)
			{
				//List<NewBuild> builder = new ArrayList<NewBuild>();
				try {
					builds = db.findBuildsByUsername(username);
					
					//builder = db.findAllBuilds();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setAttribute("blist", builds);
				//builder = builds;
				req.getRequestDispatcher("/_view/loadB.jsp").forward(req, resp);
			}
			else if(req.getParameter("selectB") != null){
				int number = Integer.parseInt(req.getParameter("selectB"));
				buildName = builds.get(number).getName();
				NewBuild build = new NewBuild();
				try {
					build = db.findBuildByBuildName(buildName, username);
					req.setAttribute("cpubuild", db.loadCPUfromModel(build.getCpu()));
					req.setAttribute("mbbuild", db.loadMOBOfromModel(build.getMotherboard()));
					req.setAttribute("gpubuild", db.loadGPUfromModel(build.getGpu()));
					req.setAttribute("rambuild", db.loadRAMfromModel(build.getRam()));
					req.setAttribute("ssdbuild", db.loadSTORAGEfromModel(build.getStorage()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}//
		
		// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/createbuild.jsp").forward(req, resp);
	}
}

