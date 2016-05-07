package QuickBuild;

import partPickerPC.Build;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

import Parts.GpuPart;
import Parts.RamPart;
import Parts.StoragePart;

public class QuickBuildController {

	private QuickBuildModel model;
	
	
	public void setModel(QuickBuildModel model)
	{
		this.model = model;
	}
	
	public Build giveCheapest()			// gives the cheapest build from compatible builds
	{
		IDatabase db    = null;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		
		 List<GpuPart> gpus = db.findAllGpusCrit(null, null, null, null, "1", "200");
		 List<RamPart> rams = db.findAllRamsCrit(null, null, null, null, "1", "200");
		 List<StoragePart> storages = db.findAllStorageCrit(null, null, "1", "200");
		 GpuPart cheapgpu;
		 RamPart cheapram;
		 StoragePart cheapstorage;
		 cheapram = rams.get(0);
		 cheapstorage = storages.get(0);
		 cheapgpu = gpus.get(0);
		 for (int i = 1; i < gpus.size(); i++)
		 {
			 if (cheapgpu.getPrice() > gpus.get(i).getPrice())
			 {
				 cheapgpu = gpus.get(i);
			 }
		 }
		 for (int i = 1; i < rams.size(); i++)
		 {
			 if (cheapram.getPrice() > rams.get(i).getPrice())
			 {
				 cheapram = rams.get(i);
			 }
		 }
		 for (int i = 1; i < storages.size(); i++)
		 {
			 if (cheapstorage.getPrice() > storages.get(i).getPrice())
			 {
				 cheapstorage = storages.get(i);
			 }
		 }
		Build cheap = model.getCompatibleBuilds().get(0);
		Build current;
		for (int i = 1; i < model.getCompatibleBuilds().size(); i++)
		{

			current = model.getCompatibleBuilds().get(i);
			if (current.getPrice() < cheap.getPrice())
			{
				cheap = current;
			}
		}
		cheap.addPart(cheapram);
		cheap.addPart(cheapstorage);
		cheap.addPart(cheapgpu);
		return cheap;
	}
	
	public Build giveExpensive()  // gives expensive
	{
		IDatabase db    = null;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		
		 List<GpuPart> gpus = db.findAllGpusCrit(null, null, null, null, "200", "99999");
		 List<RamPart> rams = db.findAllRamsCrit(null, null, null, null, "200", "99999");
		 List<StoragePart> storages = db.findAllStorageCrit(null, null, "200", "99999");
		 GpuPart cheapgpu;
		 RamPart cheapram;
		 StoragePart cheapstorage;
		 cheapram = rams.get(0);
		 cheapstorage = storages.get(0);
		 cheapgpu = gpus.get(0);
		 for (int i = 1; i < gpus.size(); i++)
		 {
			 if (cheapgpu.getPrice() < gpus.get(i).getPrice())
			 {
				 cheapgpu = gpus.get(i);
			 }
		 }
		 for (int i = 1; i < rams.size(); i++)
		 {
			 if (cheapram.getPrice() < rams.get(i).getPrice())
			 {
				 cheapram = rams.get(i);
			 }
		 }
		 for (int i = 1; i < storages.size(); i++)
		 {
			 if (cheapstorage.getPrice() < storages.get(i).getPrice())
			 {
				 cheapstorage = storages.get(i);
			 }
		 }
		Build cheap = model.getCompatibleBuilds().get(0);
		Build current;
		for (int i = 1; i < model.getCompatibleBuilds().size(); i++)
		{

			current = model.getCompatibleBuilds().get(i);
			if (current.getPrice() > cheap.getPrice())
			{
				cheap = current;
			}
		}
		cheap.addPart(cheapram);
		cheap.addPart(cheapstorage);
		cheap.addPart(cheapgpu);
		return cheap;
	}
	
	
	public Build giveCompatibleBuild(int counter)  // gives any build that works
	{
		IDatabase db    = null;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		
		 List<GpuPart> gpus = db.findAllGpusCrit(null, null, null, null, "1", "99999");
		 List<RamPart> rams = db.findAllRamsCrit(null, null, null, null, "1", "99999");
		 List<StoragePart> storages = db.findAllStorageCrit(null, null, "1", "99999");
		 ArrayList<Build> allBuilds = new ArrayList<Build>();
		if (counter < model.getCompatibleBuilds().size())
		{
		for (int s = 0; s < model.getCompatibleBuilds().size(); s++)
		{
			for (int i = 0; i < gpus.size(); i++)
			{
				for (int j = 0; j < rams.size(); j++)
				{
					for (int g = 0; g < storages.size(); g++)
					{
						allBuilds.add(new Build(model.getCompatibleBuilds().get(s).getCpu(), model.getCompatibleBuilds().get(s).getMb()
								, gpus.get(i), rams.get(j), storages.get(g)));
						
					}
				}
			}
		}
			return  allBuilds.get(counter);
			
		}
		return null;
	}
}
