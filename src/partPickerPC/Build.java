package partPickerPC;

import java.util.ArrayList;

public class Build 
{
	private ArrayList<Part> theParts;  // holds all the parts
	
	public Build()
	{
		theParts = new ArrayList<Part>();
	}
	
	
	public boolean checkCompatible(Part added)				// for minimal this just checks if there's more than
	{													    // one type of part in a build
		for (int i = 0; i < theParts.size(); i++)
		{
			if (theParts.get(i).equals(added))
			{
				return false;
			}
		}
		return true;
	}
	public void test(){
		System.err.println("1");
	}
	
	public void addPart(Part addedPart)					// adds part
	{													// not sure what to do if there's multiple
		if (checkCompatible(addedPart))
		{
		theParts.add(addedPart);
		}
		else
		{
														//add a are you sure?
		}
	}
	
	public void removePart(int number)				// removes selected part
	{
		theParts.remove(number);
	}
	
	public void quickBuild()
	{
		if (theParts.isEmpty())					// if no parts in build, start with motherboard
		{
			
		}
	}
}
