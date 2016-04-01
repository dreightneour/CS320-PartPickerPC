package junit;

import Parts.GpuPart;
import junit.framework.TestCase;

public class GpuPartTest extends TestCase {
	
	GpuPart g;
	String brand = "brand";
	String model = "model";
	String slotType = "slots";
	String gpuBase = "dropda";
	String memorySize = "goldfish";
	String url = "www.quadtitans.com";
	double price = 4795.46;
	double sale = .99;
	
	protected void setUp() throws Exception{
		g = new GpuPart(brand, model, slotType, gpuBase, memorySize, url, price, sale);
	}
	
	public void testBrand() throws Exception{
		assertEquals(brand, g.getBrand());
	}
	
	public void testModel() throws Exception{
		assertEquals(model, g.getModel());
	}
	
	public void testSlotType() throws Exception{
		assertEquals(slotType, g.getSlotType());
	}
	
	public void testGpuBase() throws Exception{
		assertEquals(gpuBase, g.getGpuBase());
	}
	
	public void testMemSize() throws Exception{
		assertEquals(memorySize, g.getMemorySize());
	}
	
	public void testUrl() throws Exception{
		assertEquals(url, g.getUrl());
	}
	
	public void testgetPrice() throws Exception{
		assertEquals(price, g.getPrice());
	}
	
	public void testsetPrice() throws Exception{
		double price2 = 1234.84;
		g.setPrice(price2);
		assertEquals(price2, g.getPrice());
	}
}
