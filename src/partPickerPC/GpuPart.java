package partPickerPC;

public class GpuPart extends Part {

	 private String brand, model, slotType, gpuBase, memorySize;
	 
	 public GpuPart(String brand, String model, String slotType, String gpuBase, String memorySize)
	 {
		 this.brand = brand;
		 this.model = model;
		 this.slotType = slotType;
		 this.gpuBase = gpuBase;
		 this.memorySize = memorySize;
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

}
