package Parts;

import partPickerPC.PartInterface;

public class CpuPart implements PartInterface {
	
	private String socketType, model, brand, series
	, frequency, cores, url;
	public int cpuId;
	double price;
	
	public CpuPart(String socketType, String model, String brand, String series,					// all the important cpu information
				   String frequency, String cores, String url, double price, double sale)
	{
		this.socketType = socketType;
		this.model = model;
		this.brand = brand;
		this.series = series;
		this.frequency = frequency;
		this.cores = cores;
		this.url = url;
		this.price = price;
		//setPartType("cpu");
	}

	public int getCpuId() {
		return cpuId;
	}

	public void setCpuId(int cpuId) {
		this.cpuId = cpuId;
	}

	public String getSocketType() {
		return socketType;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public String getSeries() {
		return series;
	}

	public String getFrequency() {
		return frequency;
	}

	public String getCores() {
		return cores;
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
