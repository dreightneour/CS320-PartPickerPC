package partPickerPC;

import java.util.ArrayList;

public class PartList {
	
	private ArrayList<CpuPart> cpus;
	private ArrayList<MotherboardPart> motherboards;
	private ArrayList<GpuPart> gpus;
	private ArrayList<RamPart> rams;
	
	public PartList() {												//TODO someone manually add in parts to these arraylist
		cpus = new ArrayList<CpuPart>();       						// requires socketType, name, brand, series, frequency, cores
		motherboards = new ArrayList<MotherboardPart>();			//requires brand, model		
		gpus = new ArrayList<GpuPart>();							// requires brand, model, slotType, gpuBase, memorySize
		rams = new ArrayList<RamPart>();							// requires brand, series, model, capacity, type, multichannelType
		
	}
	
	
	

}
