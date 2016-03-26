package partPickerPC;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;

public class Build 
{
	
	private ArrayList<PartInterface> theParts;  // holds all the parts
	private double price;
	public Build()
	{
		theParts = new ArrayList<>();
		price = 0;
	}
	
	public Build(CpuPart cpu, MotherboardPart motherboard, GpuPart gpu, RamPart ram) // used to make a build
	{
		theParts = new ArrayList<PartInterface>();
		price = 0;
		addPart(cpu);
		addPart(motherboard);
		addPart(gpu);
		addPart(ram);
		
	}
	
	
	public boolean checkCompatible(PartInterface added)				// for minimal this just checks if there's more than
	{													    		// one type of part in a build

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
	
	public void addPart(PartInterface addedPart)					// adds part
	{													// not sure what to do if there's multiple
		if (checkCompatible(addedPart))
		{
			if (addedPart instanceof MotherboardPart )
			{
				if (theParts.size() == 1)
				{
				if (checkSocketType((CpuPart) theParts.get(0), (MotherboardPart) addedPart))
				{
					theParts.add(addedPart);
					price += addedPart.getPrice();			// puts motherboard in the 2nd slot
				}
				}
			}
			else
			{
			if (addedPart instanceof GpuPart)
			{
				if (theParts.size() == 2)
				{
					theParts.add(addedPart); 				// puts gpu in the 3rd slot
					price+= addedPart.getPrice();
				}
			}
			else if (addedPart instanceof RamPart)
			{
				if (theParts.size() == 3)
				{
					theParts.add(addedPart);			// ram in the 4th slot
					price+= addedPart.getPrice();
				}
			}
			else if (addedPart instanceof CpuPart)
			{
				if (theParts.size() == 0)
				{
					theParts.add(addedPart);			// cpu in the 1st slot
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
		if (cpu.getSocketType().compareTo(motherboard.getSocketType()) == 0)	// compares cpu and mb sockettype
		{
			return true;
		}
		return false;
	}
	
	public ArrayList<PartInterface> getTheParts()
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
