package partPickerPC;

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
		
		cpus.add(new CpuPart("LGA 1150", "Core i5-4590", "Intel", "Core i5", "3.3", "4"));
		cpus.add(new CpuPart("LGA 1151", "Core i3-6100", "Intel", "Core i3", "3.7", "2"));
		cpus.add(new CpuPart("AM3+", "FX-8350 Black Edition", "AMD", "FX-Series", "4.0", "8"));
		cpus.add(new CpuPart("LGA 2011-v3", "Core i7-5930K", "Intel", "Core i7", "3.5", "6"));
		cpus.add(new CpuPart("LGA 1150", "Core i7-4790", "Intel", "Core i7", "3.6", "4"));
		cpus.get(0).setPrice(199.99);
		cpus.get(1).setPrice(124.99);
		cpus.get(2).setPrice(159.99);
		cpus.get(3).setPrice(579.99);
		cpus.get(4).setPrice(309.99);
		
		motherboards.add(new MotherboardPart("Asus", "M5A97 R2.0", "AM3+"));
		motherboards.add(new MotherboardPart("MSI", "X99A GODlike Gaming", "LGA 2011-v3"));
		motherboards.add(new MotherboardPart("GIGABYTE", "GA-B85M-DS3H-A", "LGA 1150"));
		motherboards.add(new MotherboardPart("ASRock", "Z170 Pro4s", "LGA 1151"));
		
		motherboards.get(0).setPrice(94.99);
		motherboards.get(1).setPrice(539.99);
		motherboards.get(2).setPrice(49.99);
		motherboards.get(3).setPrice(109.99);
		
		gpus.add(new GpuPart("GIGABYTE", "GV-N970XTREME-4GD", "PCI Express 3.0 x16", "GeForce GTX 970", "4"));
		gpus.add(new GpuPart("XFX", "R7-250X-CGF4", "PCI Express 3.0 x16", "Radeon R7 250X", "2"));
		gpus.add(new GpuPart("EVGA", "06G-P4-4996-KR", "PCI Express 3.0 x16", "GeForce GTX 980 Ti", "6"));
		
		gpus.get(0).setPrice(379.99);
		gpus.get(1).setPrice(89.99);
		gpus.get(2).setPrice(659.99);
		
		rams.add(new RamPart("CORSAIR", "Vengeance Pro", "CMY16GX3M2A1866C9R", "16", "DDR3", "Dual"));
		rams.add(new RamPart("G.SKILL", "Ripjaws Z Series", "F3-17000CL11Q2-64GBZLD", "64", "DDR3", "Quad"));
		rams.add(new RamPart("HyperX", "FURY", "HX421C14FBK2/8", "8", "DDR4", "none" ));
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
