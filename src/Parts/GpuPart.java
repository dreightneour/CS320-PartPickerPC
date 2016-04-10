package Parts;

import partPickerPC.PartInterface;

public class GpuPart implements PartInterface {
	
	 private String brand, model, slotType, gpuBase, memorySize, url;
	 private double price;
	 public int gpuId;
	 
	 public int getGpuId() {
		return gpuId;
	}

	public void setGpuId(int gpuId) {
		this.gpuId = gpuId;
	}

	public GpuPart(String brand, String model, String slotType, String gpuBase, String memorySize, String url, double price, double sale)
	 {
		 this.brand = brand;
		 this.model = model;
		 this.slotType = slotType;
		 this.gpuBase = gpuBase;
		 this.memorySize = memorySize;
		 this.url = url;
		 this.price = price;
	 }

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getSlotType() {
		return slotType;
	}

	public String getGpuBase() {
		return gpuBase;
	}

	public String getMemorySize() {
		return memorySize;
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
