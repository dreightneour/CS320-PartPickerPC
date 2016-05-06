package partPickerPC;

public class NewBuild {

	private String username;
	private String cpu;
	private String gpu;
	private String mother;
	private String storage;
	private String ram;
	private int build_id;
	private String name;
	
	public NewBuild()
	{
		
	}
	
	public NewBuild(String username, String cpu, String mother, String gpu, String ram, String storage, String name)
	{
		this.cpu = cpu;
		this.gpu = gpu;
		this.mother = mother;
		this.ram = ram;
		this.storage = storage;
		this.name = name;
		this.username =username;
	}
	
	public String getUser()
	{
		return username;
	}
	
	public String getCpu()
	{
		return cpu;
	}
	
	public String getGpu()
	{
		return gpu;
	}
	
	public String getMotherboard()
	{
		return mother;
	}
	
	public String getRam()
	{
		return ram;
	}
	
	public String getStorage()
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
