package partPickerPC;

public class MotherboardPart extends Part {
	int b = 0;
	private String brand, model, socketType, cpuSeries, chipset,
	memorySlots, maxMemory, supportedChannel, pciE2x16, pciEx1, pci;
	
	public MotherboardPart(String brand, String model)		// brand and model are mandatory
	{
		this.brand = brand;
		this.model = model;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public String getModel()
	{
		return model;
	}

	public String getSocketType() {
		return socketType;
	}

	public void setSocketType(String socketType) {
		this.socketType = socketType;
	}

	public String getCpuSeries() {
		return cpuSeries;
	}

	public void setCpuSeries(String cpuSeries) {
		this.cpuSeries = cpuSeries;
	}

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getMemorySlots() {
		return memorySlots;
	}

	public void setMemorySlots(String memorySlots) {
		this.memorySlots = memorySlots;
	}

	public String getMaxMemory() {
		return maxMemory;
	}

	public void setMaxMemory(String maxMemory) {
		this.maxMemory = maxMemory;
	}

	public String getSupportedChannel() {
		return supportedChannel;
	}

	public void setSupportedChannel(String supportedChannel) {
		this.supportedChannel = supportedChannel;
	}

	public String getPciE2x16() {
		return pciE2x16;
	}

	public void setPciE2x16(String pciE2x16) {
		this.pciE2x16 = pciE2x16;
	}

	public String getPciEx1() {
		return pciEx1;
	}

	public void setPciEx1(String pciEx1) {
		this.pciEx1 = pciEx1;
	}

	public String getPci() {
		return pci;
	}

	public void setPci(String pci) {
		this.pci = pci;
	}


	

}
