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
		List<CpuPart> cpus = db.findAllCpusCrit(null, null, null, null, null, "1", "999999");
		List<GpuPart> gpus = db.findAllGpusCrit(null, null, null, null, "1", "9999999");
		List<MotherboardPart> mbs = db.findAllMbsCrit(null, null, "1", "999999");
		List<RamPart> rams = db.findAllRamsCrit(null, null, null, null, "1", "999999");
		compatibleBuilds = new ArrayList<Build>();
		actualCompatibleBuilds = new ArrayList<Build>();
		for (int i = 0; i < cpus.size() / 3; i++)		// this makes every possible build
		{
			for (int j = 0; j < mbs.size() / 3; j++)
			{
				for (int g = 0; g < gpus.size() / 3; g++)
				{
					for (int f = 0; f < rams.size() / 10; f++)
					{
						compatibleBuilds.add(new Build(cpus.get(i), mbs.get(j), gpus.get(g), rams.get(f), null));
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
