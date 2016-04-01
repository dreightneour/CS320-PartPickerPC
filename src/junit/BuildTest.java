package junit;

import java.util.ArrayList;

import Parts.CpuPart;
import Parts.MotherboardPart;
import Parts.PartList;
import junit.framework.TestCase;
import partPickerPC.Build;

public class BuildTest extends TestCase {
	
	private PartList thing = new PartList();
	public void testBuildAdd1() throws Exception
	{
		Build build = new Build();
		build.addPart(thing.getCpus().get(0));
		build.addPart(thing.getRams().get(0));
		
		assertEquals(thing.getCpus().get(0), build.getCpu());
		assertEquals(thing.getRams().get(0), build.getRam());
		 
	}
	
	public void testBuildAdd2() throws Exception
	{
		
		Build build = new Build(null, null, null, thing.getRams().get(0));
		assertEquals(thing.getRams().get(0), build.getRam());
		assertEquals(null, build.getCpu());
		
	}
	
	public void testBuildAdd3() throws Exception
	{
		Build build = new Build(new CpuPart("socket", null, null, null, null, null, null, 0, 0), null, thing.getGpus().get(0), thing.getRams().get(0));
		assertFalse(build.isThisCompatible());
		MotherboardPart mb = new MotherboardPart(null, null, "socket", null, 0, 0);
		build.addPart(mb);
		assertTrue(build.isThisCompatible());
	}
	
	public void testCheckCompatible1() throws Exception
	{
		
		CpuPart a = thing.getCpus().get(0);
		CpuPart b = thing.getCpus().get(1);
		Build stuff = new Build();
		stuff.addPart(a);
		assertFalse(stuff.checkCompatible(b));
	}
	public void testCheckCompatible2() throws Exception
	{
		
		CpuPart a = thing.getCpus().get(0);
		Build stuff = new Build();
		assertTrue(stuff.checkCompatible(a));
	}
	
	public void testRemovePart() throws Exception
	{
		Build build = new Build(thing.getCpus().get(0), null, thing.getGpus().get(0), thing.getRams().get(0));
		build.removePart("cpu");
		assertEquals(null, build.getCpu());
		assertEquals(thing.getGpus().get(0), build.getGpu());
		build.removePart("gpu");
		assertEquals(null, build.getGpu());
	}
	
	public void testIsThisCompatible() throws Exception
	{
		Build build = new Build();
		Build buildfull = new Build(new CpuPart("socket", null, null, null, null, null, null, 0, 0), new MotherboardPart(null, null, "socket", null, 0, 0), thing.getGpus().get(0), thing.getRams().get(0));
		assertTrue(buildfull.isThisCompatible());
		assertFalse(build.isThisCompatible());
	}
}
