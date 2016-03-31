package junit;

import junit.framework.TestCase;
import partPickerPC.CpuPart;

public class CpuPartTest extends TestCase {
	CpuPart c;
	String socketType = "socket";
	String name = "i7";
	String brand = "myBrand";
	String series = "world";
	String frequency = "50,000 leagues";
	String cores = "fusion";
	String url = "mycpu.net";
	double price = 666.66;
	double sale = 12.10;
	protected void setUp() throws Exception{
		c = new CpuPart(socketType, name, brand, series, frequency, cores, url, price, sale);
	}
	
	public void testGetSocketType() throws Exception{
		assertEquals(socketType, c.getSocketType());
	}
	
	public void testGetName() throws Exception{
		assertEquals(name, c.getName());
	}
	
	public void testGetBrand() throws Exception{
		assertEquals(brand, c.getBrand());
	}
	
	public void testGetseries() throws Exception{
		assertEquals(series, c.getSeries());
	}
	
	public void testGetFrequency() throws Exception{
		assertEquals(frequency, c.getFrequency());
	}
	
	public void testGetCores() throws Exception{
		assertEquals(cores, c.getCores());
	}

	public void testUrl() throws Exception{
		assertEquals(url, c.getUrl());
	}
	
	public void testGetPrice() throws Exception{
		assertEquals(price, c.getPrice());
	}
	
	public void testSetPrice() throws Exception{
		double price2 = 99.99;
		c.setPrice(price2);
		assertEquals(price2, c.getPrice());
	}
	
}
