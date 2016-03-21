package partPickerPC;

public class RamPart extends Part {
	
	private String brand, series, model, capacity, type, multichannelType;
	
	public RamPart(String brand, String series, String model, String capacity, String type, String multichannelType)
	{
		this.brand = brand;
		this.series = series;
		this.model = model;
		this.capacity = capacity;
		this.type = type;
		this.multichannelType = multichannelType;
		setPartType("ram");
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


}
