package QuickBuild;

import java.util.ArrayList;
import java.util.List;

import Parts.CpuPart;
import Parts.GpuPart;
import Parts.MotherboardPart;
import Parts.PartList;
import Parts.RamPart;
import partPickerPC.Build;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class QuickBuildModel {
	private ArrayList<Build> compatibleBuilds;
	private ArrayList<Build> actualCompatibleBuilds;
	public QuickBuildModel()
	{
		IDatabase db    = null;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		List<CpuPart> cpus = db.findAllCpus();
		List<GpuPart> gpus = db.findAllGpus();
		List<MotherboardPart> mbs = db.findAllMobos();
		List<RamPart> rams = db.findAllRam();
		compatibleBuilds = new ArrayList<Build>();
		actualCompatibleBuilds = new ArrayList<Build>();
		for (int i = 0; i < cpus.size(); i++)		// this makes every possible build
		{
			for (int j = 0; j < mbs.size(); j++)
			{
				for (int g = 0; g < gpus.size(); g++)
				{
					for (int f = 0; f < rams.size(); f++)
					{
						compatibleBuilds.add(new Build(cpus.get(i), mbs.get(j), gpus.get(g), rams.get(f)));
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
