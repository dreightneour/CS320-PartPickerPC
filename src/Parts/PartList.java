package Parts;

import java.util.ArrayList;

public class PartList {
	
	private ArrayList<CpuPart> cpus;
	private ArrayList<MotherboardPart> motherboards;
	private ArrayList<GpuPart> gpus;
	private ArrayList<RamPart> rams;
	
	public PartList() {												
		cpus = new ArrayList<CpuPart>();       						// requires socketType, name, brand, series, frequency, cores
		motherboards = new ArrayList<MotherboardPart>();			//requires brand, model, socketType		
		gpus = new ArrayList<GpuPart>();							// requires brand, model, slotType, gpuBase, memorySize
		rams = new ArrayList<RamPart>();							// requires brand, series, model, capacity, type, multichannelType
		
		cpus.add(new CpuPart("LGA 1150", "Core i5-4590", "Intel", "Core i5", "3.3", "4", "http://www.newegg.com/Product/Product.aspx?Item=N82E16819116991", 199.99, 1));
		cpus.add(new CpuPart("LGA 1151", "Core i3-6100", "Intel", "Core i3", "3.7", "2", "http://www.newegg.com/Product/Product.aspx?Item=2MN-0004-00002", 124.99, 1));
		cpus.add(new CpuPart("AM3+", "FX-8350 Black Edition", "AMD", "FX-Series", "4.0", "8", "http://www.newegg.com/Product/Product.aspx?Item=N82E16819113284", 159.99, 1));
		cpus.add(new CpuPart("LGA 2011-v3", "Core i7-5930K", "Intel", "Core i7", "3.5", "6", "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117403", 579.99, 1));
		cpus.add(new CpuPart("LGA 1150", "Core i7-4790", "Intel", "Core i7", "3.6", "4", "http://www.newegg.com/Product/Product.aspx?Item=N82E16819116987", 309.99, 1));

		
		motherboards.add(new MotherboardPart("Asus", "M5A97 R2.0", "AM3+", "http://www.newegg.com/Product/Product.aspx?Item=N82E16813131873", 94.99, 1));
		motherboards.add(new MotherboardPart("MSI", "X99A GODlike Gaming", "LGA 2011-v3", "http://www.newegg.com/Product/Product.aspx?Item=N82E16813130878", 539.99, 1));
		motherboards.add(new MotherboardPart("GIGABYTE", "GA-B85M-DS3H-A", "LGA 1150", "http://www.newegg.com/Product/Product.aspx?Item=N82E16813128822", 49.99, 1));
		motherboards.add(new MotherboardPart("ASRock", "Z170 Pro4s", "LGA 1151", "http://www.newegg.com/Product/Product.aspx?Item=N82E16813157636", 109.99, 1));
		

		
		gpus.add(new GpuPart("GIGABYTE", "GV-N970XTREME-4GD", "PCI Express 3.0 x16", "GeForce GTX 970", "4", "http://www.newegg.com/Product/Product.aspx?Item=N82E16814125840", 379.99, 1));
		gpus.add(new GpuPart("XFX", "R7-250X-CGF4", "PCI Express 3.0 x16", "Radeon R7 250X", "2", "http://www.newegg.com/Product/Product.aspx?Item=N82E16814150716", 89.99, 1));
		gpus.add(new GpuPart("EVGA", "06G-P4-4996-KR", "PCI Express 3.0 x16", "GeForce GTX 980 Ti", "6", "http://www.newegg.com/Product/Product.aspx?Item=N82E16814487160", 659.99, 1));
		
		gpus.get(0).setPrice(379.99);
		gpus.get(1).setPrice(89.99);
		gpus.get(2).setPrice(659.99);
		
		rams.add(new RamPart("CORSAIR", "Vengeance Pro", "CMY16GX3M2A1866C9R", "16", "DDR3", "Dual", "http://www.newegg.com/Product/Product.aspx?Item=N82E16820233536", 69.99, 1));
		rams.add(new RamPart("G.SKILL", "Ripjaws Z Series", "F3-17000CL11Q2-64GBZLD", "64", "DDR3", "Quad", "http://www.newegg.com/Product/Product.aspx?Item=N82E16820231525", 346.99, 1));
		rams.add(new RamPart("HyperX", "FURY", "HX421C14FBK2/8", "8", "DDR4", "none", "http://www.newegg.com/Product/Product.aspx?Item=N82E16820104532", 79.95, 1));
		rams.get(0).setPrice(69.99);
		rams.get(1).setPrice(346.99);
		rams.get(2).setPrice(79.95);
		
	}

	public ArrayList<CpuPart> getCpus() {
		return cpus;
	}

	public ArrayList<MotherboardPart> getMotherboards() {
		return motherboards;
	}

	public ArrayList<GpuPart> getGpus() {
		return gpus;
	}

	public ArrayList<RamPart> getRams() {
		return rams;
	}

	
	
	

}
