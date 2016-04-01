package junit;

import junit.framework.TestCase;
import partPickerPC.Storage;
public class StorageTest extends TestCase {
	Storage s;
	String capacity = "12 TB";
	String storageType = "HD";
	String dataSpeed = "7200 RPM";
	String url = "www.testwebsite.edu";
	String brand = "brand";
	String model = "model";
	double price = 124.98;
	double sale = 43.72;
	
	protected void setUp() throws Exception{
		s = new Storage (capacity, storageType, dataSpeed, url, brand, model, price, sale);
	}
	
	public void testgetType() throws Exception{
		assertEquals(storageType, s.getStorageType());
	}
	public void testgetCapacity() throws Exception{
		assertEquals(capacity, s.getCapacity());
	}
	
	public void testgetdataSpeed() throws Exception{
		assertEquals(dataSpeed, s.getdataSpeed());
	}
	
	public void testgetUrl() throws Exception{
		assertEquals(url, s.getUrl());
	}
	
	public void testgetBrand() throws Exception{
		assertEquals(brand, s.getBrand());
	}
	
	public void testgetModel() throws Exception{
		assertEquals(model, s.getModel());
	}
	
	public void testgetPrice() throws Exception{
		assertEquals(price, s.getPrice());
	}
	
	public void testsetPrice() throws Exception{
		double price2 = 19.45;
		s.setPrice(price2);
		assertEquals(price2, s.getPrice());
	}
}
