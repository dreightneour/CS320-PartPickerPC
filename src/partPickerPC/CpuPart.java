package partPickerPC;

public class CpuPart extends Part {

	private String socketType, name, brand, series
	, frequency, cores;
	
	public CpuPart(String socketType, String name, String brand, String series,					// all the important cpu information
				   String frequency, String cores)
	{
		this.socketType = socketType;
		this.name = name;
		this.brand = brand;
		this.series = series;
		this.frequency = frequency;
		this.cores = cores;
	}

	public String getSocketType() {
		return socketType;
	}

	public String getName() {
		return name;
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

	
	
	
	
	
	
}
