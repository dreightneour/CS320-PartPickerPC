package junit;

import Parts.CpuPart;
import Parts.GpuPart;
import Parts.MotherboardPart;
import Parts.RamPart;
import junit.framework.TestCase;
import partPickerPC.Search;

public class SearchTests extends TestCase
{
	
	public void testCpuSearch1() throws Exception
	{	
		String frequency = "4.0 GHz";
		String brand = "Intel";
		String series = "Core i7";
		String socketType = "LGA 1150";
		String Model = "Core i7-4790K";
		String cores = "Quad-Core";				
		CpuPart cpu = new CpuPart(socketType, Model, brand, series, frequency, cores, "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369", 349.99, 1);
		CpuPart cpu1Check = Search.getCPU("http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369");	
		
		assertEquals(cpu.getBrand(), cpu1Check.getBrand());
		assertEquals(cpu.getCores(), cpu1Check.getCores());
		assertEquals(cpu.getFrequency(), cpu1Check.getFrequency());
		assertEquals(cpu.getModel(), cpu1Check.getModel());
		assertEquals(cpu.getSeries(), cpu1Check.getSeries());
		assertEquals(cpu.getSocketType(), cpu1Check.getSocketType());

	
	}
	
	public void testCpuSearch2() throws Exception
	{
		String frequency2 = "3.5 GHz";
		String brand2 = "Intel";
		String series2 = "Core i5";
		String socketType2 = "LGA 1150";
		String Model2 = "Core i5-4690K";
		String cores2 = "Quad-Core";				
		CpuPart cpu2 = new CpuPart(socketType2, Model2, brand2, series2, frequency2, cores2, "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117372", 1, 1);
		CpuPart cpu2Check = Search.getCPU("http://www.newegg.com/Product/Product.aspx?Item=N82E16819117372");	
		
		assertEquals(cpu2.getBrand(), cpu2Check.getBrand());
		assertEquals(cpu2.getCores(), cpu2Check.getCores());
		assertEquals(cpu2.getFrequency(), cpu2Check.getFrequency());
		assertEquals(cpu2.getModel(), cpu2Check.getModel());
		assertEquals(cpu2.getSeries(), cpu2Check.getSeries());
		assertEquals(cpu2.getSocketType(), cpu2Check.getSocketType());
	}
	
	
	public void testCpuSearch3() throws Exception
	{	
		String frequency = "4.0 GHz (4.2GHz Turbo)";
		String brand = "AMD";
		String series = "FX-Series";
		String socketType = "Socket AM3+";
		String Model = "FX-8350 Black Edition";
		String cores = "8-Core";				
		CpuPart cpu = new CpuPart(socketType, Model, brand, series, frequency, cores, "http://www.newegg.com/Product/Product.aspx?Item=N82E16819113284", 1, 1);
		CpuPart cpu1Check = Search.getCPU("http://www.newegg.com/Product/Product.aspx?Item=N82E16819113284");	
		
		assertEquals(cpu.getBrand(), cpu1Check.getBrand());
		assertEquals(cpu.getCores(), cpu1Check.getCores());
		assertEquals(cpu.getFrequency(), cpu1Check.getFrequency());
		assertEquals(cpu.getModel(), cpu1Check.getModel());
		assertEquals(cpu.getSeries(), cpu1Check.getSeries());
		assertEquals(cpu.getSocketType(), cpu1Check.getSocketType());

	
	}
	
	public void testMotherboardSearch1() throws Exception
	{	
		String brand = "ASUS";
		String model = "CROSSBLADE RANGER";
		String socketType = "FM2+";
		
		MotherboardPart mother = new MotherboardPart(brand, model, socketType, "http://www.newegg.com/Product/Product.aspx?Item=N82E16813132255", 1, 1);
		MotherboardPart motherCheck = Search.getMotherboard("http://www.newegg.com/Product/Product.aspx?Item=N82E16813132255");	
		
		assertEquals(mother.getBrand(), motherCheck.getBrand());
		assertEquals(mother.getModel(), motherCheck.getModel());
		assertEquals(mother.getSocketType(), motherCheck.getSocketType());

	
	}
	
	public void testMotherboardSearch2() throws Exception
	{	
		String brand = "MSI";
		String model = "Z97 GAMING 5";
		String socketType = "LGA 1150";
		
		MotherboardPart mother = new MotherboardPart(brand, model, socketType, "http://www.newegg.com/Product/Product.aspx?Item=N82E16813130770", 1, 1);
		MotherboardPart motherCheck = Search.getMotherboard("http://www.newegg.com/Product/Product.aspx?Item=N82E16813130770");	
		
		assertEquals(mother.getBrand(), motherCheck.getBrand());
		assertEquals(mother.getModel(), motherCheck.getModel());
		assertEquals(mother.getSocketType(), motherCheck.getSocketType());

	
	}
	
	public void testGpuSearch1() throws Exception
	{	
		String memorySize = "2GB";
		String brand = "EVGA";
		String gpuBase = "GDDR5";
		String slotType = "PCI Express 3.0 x16";
		String model = "02G-P4-2958-KR";
			
		GpuPart gpu = new GpuPart(brand, model, slotType, gpuBase, memorySize, "http://www.newegg.com/Product/Product.aspx?Item=N82E16814487159", 1, 1);
		GpuPart gpu1Check = Search.getGpu("http://www.newegg.com/Product/Product.aspx?Item=N82E16814487159");	
		
		assertEquals(gpu.getBrand(), gpu1Check.getBrand());
		assertEquals(gpu.getModel(), gpu1Check.getModel());
		assertEquals(gpu.getSlotType(), gpu1Check.getSlotType());
		assertEquals(gpu.getGpuBase(), gpu1Check.getGpuBase());
		assertEquals(gpu.getMemorySize(), gpu1Check.getMemorySize());

	
	}
	
	public void testGpuSearch2() throws Exception
	{	
		String memorySize = "8GB";
		String brand = "MSI";
		String gpuBase = "GDDR5";
		String slotType = "PCI Express 3.0";
		String model = "R9 390X GAMING 8G";
			
		GpuPart gpu = new GpuPart(brand, model, slotType, gpuBase, memorySize, "http://www.newegg.com/Product/Product.aspx?Item=N82E16814127872", 1, 1);
		GpuPart gpu1Check = Search.getGpu("http://www.newegg.com/Product/Product.aspx?Item=N82E16814127872");	
		
		assertEquals(gpu.getBrand(), gpu1Check.getBrand());
		assertEquals(gpu.getModel(), gpu1Check.getModel());
		assertEquals(gpu.getSlotType(), gpu1Check.getSlotType());
		assertEquals(gpu.getGpuBase(), gpu1Check.getGpuBase());
		assertEquals(gpu.getMemorySize(), gpu1Check.getMemorySize());

	
	}
	
	public void testRamSearch1() throws Exception
	{	
		String multichannelType = "Dual Channel Kit";
		String brand = "CORSAIR";
		String capacity = "8GB (2 x 4GB)";
		String type = "240-Pin DDR3 SDRAM";
		String model = "CMZ8GX3M2A1600C9";
		String series = "Vengeance";
			
		RamPart ram = new RamPart(brand, series, model, capacity, type, multichannelType, "http://www.newegg.com/Product/Product.aspx?Item=N82E16820233144", 1, 1);
		RamPart ram1Check = Search.getRam("http://www.newegg.com/Product/Product.aspx?Item=N82E16820233144");	
		
		assertEquals(ram.getBrand(), ram1Check.getBrand());
		assertEquals(ram.getModel(), ram1Check.getModel());
		assertEquals(ram.getSeries(), ram1Check.getSeries());
		assertEquals(ram.getCapacity(), ram1Check.getCapacity());
		assertEquals(ram.getType(), ram1Check.getType());
		assertEquals(ram.getMultichannelType(), ram1Check.getMultichannelType());

	
	}
	
	public void testRamSearch2() throws Exception
	{	
		String multichannelType = "";
		String brand = "HyperX";
		String capacity = "16GB (2 x 8GB)";
		String type = "288-Pin DDR4 SDRAM";
		String model = "HX426C15FBK2/16";
		String series = "FURY";
			
		RamPart ram = new RamPart(brand, series, model, capacity, type, multichannelType, "http://www.newegg.com/Product/Product.aspx?Item=N82E16820104573", 1, 1);
		RamPart ram1Check = Search.getRam("http://www.newegg.com/Product/Product.aspx?Item=N82E16820104573");	
		
		assertEquals(ram.getBrand(), ram1Check.getBrand());
		assertEquals(ram.getModel(), ram1Check.getModel());
		assertEquals(ram.getSeries(), ram1Check.getSeries());
		assertEquals(ram.getCapacity(), ram1Check.getCapacity());
		assertEquals(ram.getType(), ram1Check.getType());
		assertEquals(ram.getMultichannelType(), ram1Check.getMultichannelType());

	
	}
	
}
