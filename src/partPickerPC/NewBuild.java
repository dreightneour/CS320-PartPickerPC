package partPickerPC;

public class NewBuild {

	private String username;
	private int cpu;
	private int gpu;
	private int mother;
	private int storage;
	private int ram;
	private int build_id;
	private String name;
	
	public NewBuild()
	{
		
	}
	public NewBuild(String username, int cpu, int mother, int gpu, int ram, int storage, String name)
	{
		this.cpu = cpu;
		this.gpu = gpu;
		this.mother = mother;
		this.ram = ram;
		this.storage = storage;
		this.name = name;
	}
	
	public String getUser()
	{
		return username;
	}
	
	public int getCpu()
	{
		return cpu;
	}
	
	public int getGpu()
	{
		return gpu;
	}
	
	public int getMotherboard()
	{
		return mother;
	}
	
	public int getRam()
	{
		return ram;
	}
	
	public int getStorage()
	{
		return storage;
	}
	
	public String getName()
	{
		return name;
	}

	public void setBuildId(int buildId) {
		// TODO Auto-generated method stub
		this.build_id = buildId;
	}
	
	public int getId()
	{
		return build_id;
	}
}
