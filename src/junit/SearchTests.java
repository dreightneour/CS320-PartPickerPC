package junit;

import junit.framework.TestCase;
import partPickerPC.CpuPart;
import partPickerPC.Search;

public class SearchTests extends TestCase
{
	
	public void testCpuSearch1() throws Exception
	{	
		String frequency = "4.0 GHz";
		String brand = "Intel";
		String series = "Core i7";
		String socketType = "LGA 1150";
		String name = "Core i7-4790K";
		String cores = "Quad-Core";				
		CpuPart cpu = new CpuPart(socketType, name, brand, series, frequency, cores);
		CpuPart cpu1Check = Search.getCPU("http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369");	
		
		assertEquals(cpu.getBrand(), cpu1Check.getBrand());
		assertEquals(cpu.getCores(), cpu1Check.getCores());
		assertEquals(cpu.getFrequency(), cpu1Check.getFrequency());
		assertEquals(cpu.getName(), cpu1Check.getName());
		assertEquals(cpu.getSeries(), cpu1Check.getSeries());
		assertEquals(cpu.getSocketType(), cpu1Check.getSocketType());

	
	}
	
	public void testCpuSearch2() throws Exception
	{
		String frequency2 = "3.5 GHz";
		String brand2 = "Intel";
		String series2 = "Core i5";
		String socketType2 = "LGA 1150";
		String name2 = "Core i5-4690K";
		String cores2 = "Quad-Core";				
		CpuPart cpu2 = new CpuPart(socketType2, name2, brand2, series2, frequency2, cores2);
		CpuPart cpu2Check = Search.getCPU("http://www.newegg.com/Product/Product.aspx?Item=N82E16819117372");	
		
		assertEquals(cpu2.getBrand(), cpu2Check.getBrand());
		assertEquals(cpu2.getCores(), cpu2Check.getCores());
		assertEquals(cpu2.getFrequency(), cpu2Check.getFrequency());
		assertEquals(cpu2.getName(), cpu2Check.getName());
		assertEquals(cpu2.getSeries(), cpu2Check.getSeries());
		assertEquals(cpu2.getSocketType(), cpu2Check.getSocketType());
	}
	
	
	
}
