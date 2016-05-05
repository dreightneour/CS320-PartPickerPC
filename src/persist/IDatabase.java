package persist;

import java.sql.SQLException;
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
	public CpuPart findCpuWithID(int CPUID);
	public GpuPart findGpuWithID(int GPUID);
	public MotherboardPart findMBWithID(int MBID);
	public RamPart findRAMWithID(int RAMID);
	public void insertUser(final String user, final String password) throws SQLException;
	public User findUserAlone(final String regusername);
	StoragePart findStorageWithID(int STOID);
	List<StoragePart> findAllStorageCrit(String brand, String capacity, String low, String high);
	List<StoragePart> findAllStorageCrit(String brand, String low, String high);
	void writeStoragePrice(double price, int ssdInt) throws SQLException;
	void writeCpuPrice(double price, int cpuInt) throws SQLException;
	void writeMotherPrice(double price, int motherInt) throws SQLException;
	void writeRamPrice(double price, int ramInt) throws SQLException;
	void writeGpuPrice(double price, int gpuInt) throws SQLException;
	void writeStorageBuild(int ssdInt, int buildId) throws SQLException;
	void writeCpuBuild(int cpuInt, int buildId) throws SQLException;
	void writeGpuBuild(String model, String name) throws SQLException;
	void writeRamBuild(int ramInt, int buildId) throws SQLException;
	void writeMotherBuild(int motherInt, int buildId) throws SQLException;
	List<NewBuild> findAllBuilds();
	List<NewBuild> findBuildsByUsername(String username) throws SQLException;
	void insertBuild(int user_id, String name) throws SQLException;
}
