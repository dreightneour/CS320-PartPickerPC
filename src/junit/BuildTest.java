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
		 Build testing = new Build();
		 testing.addPart(parts.getCpus().get(0));
		 assertEquals(1, testing.getTheParts().size());
		 
		 
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
