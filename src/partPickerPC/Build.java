package partPickerPC;

import java.util.ArrayList;

public class Build 
{
	private ArrayList<Part> theBuild;  // holds all the parts
	
	
	public boolean checkCompatible(Part added)				// for minimal this just checks if there's more than
	{													    // one type of part in a build
		for (int i = 0; i < theBuild.size(); i++)
		{
			if (theBuild.get(i).getType() == added.getType())
			{
				return false;
			}
		}
		return true;
	}
	public void test(){
		System.err.println("1");
	}
}
