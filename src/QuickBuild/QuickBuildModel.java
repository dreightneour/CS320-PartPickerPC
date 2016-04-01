package QuickBuild;

import java.util.ArrayList;

import Parts.PartList;
import partPickerPC.Build;

public class QuickBuildModel {
	private PartList parts;
	private ArrayList<Build> compatibleBuilds;
	private ArrayList<Build> actualCompatibleBuilds;
	public QuickBuildModel()
	{
		PartList parts = new PartList();
		compatibleBuilds = new ArrayList<Build>();
		actualCompatibleBuilds = new ArrayList<Build>();
		for (int i = 0; i < parts.getCpus().size(); i++)		// this makes every possible build
		{
			for (int j = 0; j < parts.getMotherboards().size(); j++)
			{
				for (int g = 0; g < parts.getGpus().size(); g++)
				{
					for (int f = 0; f < parts.getRams().size(); f++)
					{
						compatibleBuilds.add(new Build(parts.getCpus().get(i), parts.getMotherboards().get(j), parts.getGpus().get(g), parts.getRams().get(f)));
					}
				}
			}
		}
		Build[] test = new Build[compatibleBuilds.size()];
		for (int i = 0; i < compatibleBuilds.size(); i++)			// this removes incompatible builds
		{
			
			test[i] = compatibleBuilds.get(i);
			if (!test[i].isThisCompatible())
			{
				test[i] = null;
			}
		}
		for (int i = 0; i < test.length; i++)
		{
			if (test[i] != null)
			{
				actualCompatibleBuilds.add(test[i]);
			}
		}
		
	}
	
	public ArrayList<Build> getCompatibleBuilds()
	{
		return actualCompatibleBuilds;
	}
	
	
	
}
