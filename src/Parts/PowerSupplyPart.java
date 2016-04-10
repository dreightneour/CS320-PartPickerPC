package Parts;

import partPickerPC.PartInterface;












public class PowerSupplyPart implements PartInterface {
	private int wattage;
	private String url;
	private String brand;
	private String model;
	private double price;
	private int sale;
	public int psuId;
	public int getPsuId() {
		return psuId;
	}

	public void setPsuId(int psuId) {
		this.psuId = psuId;
	}

	public PowerSupplyPart(int wattage, String brand, String url, String model, double price, int sale){
		this.wattage = wattage;
		this.brand = brand;
		this.url = url;
		this.model = model;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return this.url;
	}
}
