package junit;

import java.util.ArrayList;
import java.util.List;

import Parts.CpuPart;
import Parts.GpuPart;
import Parts.MotherboardPart;
import Parts.RamPart;
import junit.framework.TestCase;
import partPickerPC.Search;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;


public class QueryTest extends TestCase {
	

	public void testCpuCritSearch1() throws Exception
	{
		IDatabase db    = null;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		
		List<CpuPart> a;
		a = db.findAllCpusCrit(null, null, "Core i7", null, null, "1", "9999999");
		
		for (int i = 0; i < a.size(); i++)
		{
			//System.out.println(a.get(i).getUrl());
		}
		 
	}
	
	public void testMbCritSearch1() throws Exception
	{
		IDatabase db    = null;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		
		List<MotherboardPart> a;
		a = db.findAllMbsCrit(null, "FM2+", "1", "9999999");
		
		for (int i = 0; i < a.size(); i++)
		{
			//System.out.println(a.get(i).getUrl());
		}
	}
	
	public void testGpuCritSearch1() throws Exception
	{
		IDatabase db    = null;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		
		List<GpuPart> a;
		a = db.findAllGpusCrit("EVGA", "GDDR5", "PCI Express 3.0 x16", "2GB", "0", "9999");
		
		for (int i = 0; i < a.size(); i++)
		{
			System.out.println(a.get(i).getUrl());
		}
	}
	
	public void testRamCritSearch1() throws Exception
	{
		IDatabase db    = null;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		
		List<RamPart> a;
		a = db.findAllRamsCrit("CORSAIR", "240-Pin DDR3 SDRAM", "8GB (2 x 4GB)", "Dual Channel Kit", "0", "40");
		
		for (int i = 0; i < a.size(); i++)
		{
			//System.out.println(a.get(i).getUrl());
		}
	}

}
	
	