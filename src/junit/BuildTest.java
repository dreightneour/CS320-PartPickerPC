package junit;

import java.util.ArrayList;

import junit.framework.TestCase;
import partPickerPC.Build;
import partPickerPC.CpuPart;
import partPickerPC.MotherboardPart;
import partPickerPC.PartList;

public class BuildTest extends TestCase {
	
	
	public void testBuildAdd() throws Exception
	{
		int counter = 0;
		 ArrayList<Build> theBuilds = new ArrayList<Build>();
		 PartList parts = new PartList();
		 for (int i = 0; i < parts.getCpus().size(); i++)
		 {
			 for (int j = 0; j < parts.getMotherboards().size(); j++)
			 {
				 for (int f = 0; f < parts.getGpus().size(); f++)
				 {
					for (int b = 0; b < parts.getRams().size(); b++)
					{
						theBuilds.add(new Build(parts.getCpus().get(i), parts.getMotherboards().get(j), parts.getGpus().get(f), parts.getRams().get(b)));
						counter++;
					}
				 }
			 }
		 }
	for (int i = 0; i < theBuilds.size(); i++)
	{
		if (theBuilds.get(i).getTheParts().size() == 5)
		{
			System.out.println("" + theBuilds.get(i).getTheParts().size());
		}
	}
	}
	
	public void testCompatible() throws Exception
	{
		PartList thing = new PartList();
		CpuPart a = thing.getCpus().get(0);
		CpuPart b = thing.getCpus().get(1);
		Build stuff = new Build();
		stuff.addPart(a);
		stuff.addPart(b);
		assertEquals(1, stuff.getTheParts().size());
	}
}
