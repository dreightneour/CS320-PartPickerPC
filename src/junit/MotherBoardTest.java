package junit;

import junit.framework.TestCase;
import partPickerPC.MotherboardPart;

public class MotherBoardTest extends TestCase {
	MotherboardPart mb;
	String brand = "Gigabyte";
	String model = "d1ck5";
	String socketType = "sql";
	String url = "www.testurl.com";
	double price = 130.99; 
	double sale = 40.15;
	protected void setUp() throws Exception{
		mb = new MotherboardPart( brand, model, socketType, url, price, sale);
	}
	
	public void testGetBrand() throws Exception{
		assertEquals(brand, mb.getBrand());
	}
	
	public void testGetModel() throws Exception{
		assertEquals(model, mb.getModel());
	}
	
	public void testGetSocketType() throws Exception{
		assertEquals(socketType, mb.getSocketType());
	} 
	
	public void testSetSocketType() throws Exception{
		String socketType2 = "thisIsATest1234";
		mb.setSocketType(socketType2);
		assertEquals(socketType2, mb.getSocketType());
	}
	
	public void testSetCPUSeries() throws Exception{
		String CpuSeries = "intel";
		mb.setCpuSeries(CpuSeries);
		assertEquals(CpuSeries, mb.getCpuSeries());
	}
	
	public void testSetChipSet() throws Exception{
		String chipset = "i7";
		mb.setChipset(chipset);
		assertEquals(chipset, mb.getChipset());
	}
	
	public void testSetMemorySlots() throws Exception{
		String memSlots = "ddr3";
		mb.setMemorySlots(memSlots);
		assertEquals(memSlots, mb.getMemorySlots());
	}
	
	public void testMaxMem() throws Exception{
		String memMax = "12mb";
		mb.setMaxMemory(memMax);
		assertEquals(memMax, mb.getMaxMemory());
	}
	
	public void testSupportedChannel() throws Exception{
		String channel = "BBC";
		mb.setSupportedChannel(channel);
		assertEquals(channel, mb.getSupportedChannel());
	}
	
	public void testPciE2x16() throws Exception{
		String pci16 = "card";
		mb.setPciE2x16(pci16);
		assertEquals(pci16, mb.getPciE2x16());
	}
	
	public void testPciEx1() throws Exception{
		String pci1 = "othercard";
		mb.setPciEx1(pci1);
		assertEquals(pci1, mb.getPciEx1());
	}
	
	public void testPci() throws Exception{
		String pci = "otherothercard";
		mb.setPci(pci);
		assertEquals(pci, mb.getPci());
	}
	
	
	
	public void testGetPrice() throws Exception{
		assertEquals(price, mb.getPrice());
	}
	
	public void testSetPrice() throws Exception{
		double price2 = 69.69;
		mb.setPrice(price2);
		assertEquals(price2, mb.getPrice());
	}
	
	public void testGetURL() throws Exception{
		assertEquals(url, mb.getUrl());
	}
	
	
}
