package Parts;

import partPickerPC.PartInterface;

public class RamPart implements PartInterface {
	
	private String brand, series, model, capacity, type, multichannelType, url;
	private double price;
	
	public RamPart(String brand, String series, String model, String capacity, String type, String multichannelType
					, String url, double price, double sale)
	{
		this.brand = brand;
		this.series = series;
		this.model = model;
		this.capacity = capacity;
		this.type = type;
		this.multichannelType = multichannelType;
		this.url = url;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public String getSeries() {
		return series;
	}

	public String getModel() {
		return model;
	}

	public String getCapacity() {
		return capacity;
	}

	public String getType() {
		return type;
	}

	public String getMultichannelType() {
		return multichannelType;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
		
	}

	@Override
	public String getUrl() {
		return url;
	}


}
