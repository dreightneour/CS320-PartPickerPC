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
	public QuickBuildModel()
	{
		IDatabase db    = null;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		List<CpuPart> cpus = db.findAllCpusCrit(null, null, null, null, null, "1", "999999");
		List<MotherboardPart> mbs = db.findAllMbsCrit(null, null, "1", "999999");
		compatibleBuilds = new ArrayList<Build>();
		
		for (int i = 0; i < cpus.size(); i++)
		{
			for (int j = 0; j < mbs.size(); j++)
			{
				if (cpus.get(i).getSocketType().compareTo(mbs.get(j).getSocketType())== 0 )
				{
					compatibleBuilds.add(new Build(cpus.get(i), mbs.get(j), null, null, null));
				}
			}
		}
	}
	
	public ArrayList<Build> getCompatibleBuilds()
	{
		return compatibleBuilds;
	}
	
	
	
	
	
}
