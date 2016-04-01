package junit;

import Parts.RamPart;
import junit.framework.TestCase;

public class RamPartTest extends TestCase {
	RamPart r;
	String brand = "hotIron";
	String series = "set";
	String model = "catWalk";
	String capacity = "enough";
	String type = "tallBlonde";
	String multichannelType = "something";
	String url = "www.ramitin.org";
	double price = 555.67;
	double sale = 42.00;
	
	protected void setUp() throws Exception{
		r = new RamPart(brand, series, model, capacity, type, multichannelType, url, price, sale);
	}
	
	public void testBrand() throws Exception{
		assertEquals(brand, r.getBrand());
	}
	
	public void testSeries() throws Exception{
		assertEquals(series, r.getSeries());
	}
	
	public void testModel() throws Exception{
		assertEquals(model, r.getModel());
	}
	
	public void testCapacity() throws Exception{
		assertEquals(capacity, r.getCapacity());
	}
	
	public void testType() throws Exception{
		assertEquals(type, r.getType());
	}
	
	public void testmultchanType() throws Exception{
		assertEquals(multichannelType, r.getMultichannelType());
	}
	
	public void testUrl() throws Exception{
		assertEquals(url, r.getUrl());
	}
	
	public void testgetPrice() throws Exception{
		assertEquals(price, r.getPrice());
	}
	
	public void testsetPrice() throws Exception{
		double price2 = 32.12;
		r.setPrice(price2);
		assertEquals(price2, r.getPrice());
	}
}
