package junit;

import junit.framework.TestCase;
import partPickerPC.Part;

public class PartTests extends TestCase {
	int b = 0;
	Part p;
	String sp = "3.4 GHz";
	String manufact = "Intel";
	String series = "i7";
	double price = 249.99;
	boolean onSale = true;
	double percent = 50;
	protected void setUp() throws Exception{
		p = new Part();
	}
	public void testAttributes() throws Exception{
		/*p.updateAttributes(sp);
		p.updateAttributes(manufact);
		p.updateAttributes(series);
		assertEquals(3, p.getAttr().size());*/
	}
	
	public void testPrice() throws Exception{
		p.setPrice(price);
		assertEquals(price, p.getPrice());
	}
	public void testOnSale() throws Exception{
		p.setSale(onSale);
		assertEquals(true, p.getSale());
	}
	public void testMarkDown() throws Exception{
		p.setSalePercentage(percent);
		assertEquals(percent, p.getSalePercent());
	}

}
