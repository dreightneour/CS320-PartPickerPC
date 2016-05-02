package CreateBuild;

import java.util.ArrayList;
import java.util.List;

import Parts.CpuPart;
import Parts.MotherboardPart;
import partPickerPC.Build;
import partPickerPC.PartInterface;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class CreateBuildController {
	
	private CreateBuildModel model;
	private IDatabase db;
	
	public CreateBuildController()
	{
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}

	public CreateBuildModel getModel() {
		return model;

	}



	public void setModel(CreateBuildModel model) {
		this.model = model;
	}
	
	public String addPartToParts(PartInterface part)
	{
		model.getTheBuild().addPart(part);
		if (model.getTheBuild().didPartGetAdded(part))
		{
			return "Part successfully added!";
		}
		else
		{
			return model.getTheBuild().getError();
		}
	}
	
	public String removePart(String part)
	{
		model.getTheBuild().removePart(part);
		return "Part Successfully removed";
	}
	
	public ArrayList<CpuPart> compatibleCpu(ArrayList<CpuPart> cpuCrit, Build theBuild)
	{
		if (theBuild.getMb() != null)
		{
		ArrayList<CpuPart> compatible = new ArrayList<CpuPart>();
		for (int i = 0; i < cpuCrit.size(); i++)
		{
			if (theBuild.checkSocketType(cpuCrit.get(i), theBuild.getMb()))
					{
						compatible.add(cpuCrit.get(i));
					}
		}
		return compatible;
		}
		return cpuCrit;
	}
	
	public ArrayList<MotherboardPart> compatibleMb(ArrayList<MotherboardPart> mbCrit, Build theBuild)
	{
		if (theBuild.getMb() != null)
		{
		ArrayList<MotherboardPart> compatible = new ArrayList<MotherboardPart>();
		for (int i = 0; i < mbCrit.size(); i++)
		{
			if (theBuild.checkSocketType(theBuild.getCpu(), mbCrit.get(i)))
					{
						compatible.add(mbCrit.get(i));
					}
		}
		return compatible;
		}
		return mbCrit;
	}
	
	
	
	
	
	
	

}