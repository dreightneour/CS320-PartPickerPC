package junit;

import java.util.ArrayList;
import java.util.List;

import Parts.CpuPart;


import junit.framework.TestCase;
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
			System.out.println(a.get(i).getUrl());
		}
		 
	}

}
	
	