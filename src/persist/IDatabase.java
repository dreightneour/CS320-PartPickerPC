package persist;

import java.util.List;

import Parts.*;
import partPickerPC.*;

public interface IDatabase {
	public List<CpuPart> findAllCpus();
	public List<GpuPart> findAllGpus();
	public List<MotherboardPart> findAllMobos();
	public List<PowerSupplyPart> findAllPSUs();
	public List<StoragePart> findAllStorage();
	public List<RamPart> findAllRam();
	public User findUser(final String username, final String password);
	public List<PartInterface> findPriceRange(final String partType, final String lowerend, final String higherend);
	public List<CpuPart> findAllCpusCrit(String socketType, String brand, String series, String frequency,
			String cores, String low, String high);
	public List<MotherboardPart> findAllMbsCrit(String brand, String socketType, String low, String high);
	public List<GpuPart> findAllGpusCrit(String brand, String series, String slotType, String memorySize, String low, String high);
	public List<RamPart> findAllRamsCrit(String brand, String type, String capacity, String multichannel, String low, String high);
}
