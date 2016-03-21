package partPickerPC;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Build 
{
	
	private ArrayList<Part> theParts;  // holds all the parts
	private double price;
	public Build()
	{
		theParts = new ArrayList<Part>();
		price = 0;
	}
	
	public Build(CpuPart cpu, MotherboardPart motherboard, GpuPart gpu, RamPart ram)
	{
		price = 0;
		theParts = new ArrayList<Part>();
		addPart(cpu);
		addPart(motherboard);
		addPart(gpu);
		addPart(ram);
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
			if (addedPart.getPartType().compareTo("motherboard") == 0)
			{
				if (theParts.size() == 1)
				{
				if (checkSocketType((CpuPart) theParts.get(0), (MotherboardPart) addedPart))
				{
					theParts.add(addedPart);
					price += addedPart.getPrice();
				}
				}
			}
			else
			{
			if (addedPart.getPartType().compareTo("gpu") == 0)
			{
				if (theParts.size() == 2)
				{
					theParts.add(addedPart);
					price+= addedPart.getPrice();
				}
			}
			else if (addedPart.getPartType().compareTo("ram") == 0)
			{
				if (theParts.size() == 3)
				{
					theParts.add(addedPart);
					price+= addedPart.getPrice();
				}
			}
			else if (addedPart.getPartType().compareTo("cpu") == 0)
			{
				if (theParts.size() == 0)
				{
					theParts.add(addedPart);
					price+= addedPart.getPrice();
				}
			}
			}
		}
	}
	
	public void removePart(int number)				// removes selected part
	{
		theParts.remove(number);
	}
	
	public boolean checkSocketType(CpuPart cpu, MotherboardPart motherboard)
	{
		if (cpu.getSocketType().compareTo(motherboard.getSocketType()) == 0)
		{
			return true;
		}
		return false;
	}
	
	public ArrayList<Part> getTheParts()
	{
		return theParts;
	}
	
	public double getPrice()
	{
		return round(price, 2);
	}
	
	public double round(double value, int places) {
	//taken from stackoverflow

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
