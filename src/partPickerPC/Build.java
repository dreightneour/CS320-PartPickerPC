package partPickerPC;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;

import Parts.CpuPart;
import Parts.GpuPart;
import Parts.MotherboardPart;
import Parts.RamPart;

public class Build 
{
	private CpuPart cpu;
	private MotherboardPart mb;
	private GpuPart gpu;
	private RamPart ram;
	private double price;
	public Build()
	{
		price = 0;
	}
	
	public Build(CpuPart cpu, MotherboardPart motherboard, GpuPart gpu, RamPart ram) // used to make a build
	{
		price = 0;

		addPart(cpu);
		addPart(motherboard);
		addPart(gpu);
		addPart(ram);
		
	}
	
	
	public CpuPart getCpu() {
		return cpu;
	}

	public MotherboardPart getMb() {
		return mb;
	}

	public GpuPart getGpu() {
		return gpu;
	}

	public RamPart getRam() {
		return ram;
	}

	public boolean checkCompatible(PartInterface added)				// for minimal this just checks if there's more than
	{													    		// one type of part in a build

		if ((added instanceof CpuPart && cpu == null) || (added instanceof MotherboardPart && mb == null) ||
				(added instanceof GpuPart && gpu == null) || (added instanceof RamPart && ram == null))
		{
			return true;
		}
		return false;
	}

	
	public void addPart(PartInterface addedPart)					// adds part
	{													// not sure what to do if there's multiple
		if (checkCompatible(addedPart))
		{
			if (addedPart instanceof MotherboardPart)   //f
			{
				if (cpu != null)  // if there's a cpu, check the socket types
				{
					if (checkSocketType(cpu, (MotherboardPart)addedPart))
					{
					mb = (MotherboardPart) addedPart;
					price += addedPart.getPrice();
					}
				}
				else
				{
					mb = (MotherboardPart) addedPart;
					price += addedPart.getPrice();
				}
				
			}
			else if (addedPart instanceof CpuPart)
			{
				if (mb != null)  // if there's a motherboard, check the socket types
				{
					if (checkSocketType((CpuPart) addedPart, mb))
					{
						cpu = (CpuPart) addedPart;
						price += addedPart.getPrice();
					}
				}
				else
				{
					cpu = (CpuPart) addedPart;
					price += addedPart.getPrice();
				}
			}
			else if (addedPart instanceof GpuPart)
			{
				gpu = (GpuPart) addedPart;
				price+= addedPart.getPrice();
			}
			else if (addedPart instanceof RamPart)
			{
				ram = (RamPart) addedPart;
				price+= addedPart.getPrice();
			}
			
		}
	}
	
	public void removePart(String part)				// removes selected part (string should be cpu, mb, gpu, or ram)
	{
		if (part.compareTo("cpu") == 0)
		{
			cpu = null;
		}
		else if (part.compareTo("mb") == 0)
		{
			mb = null;
		}
		else if (part.compareTo("gpu") == 0)
		{
			gpu = null;
		}
		else if (part.compareTo("ram") == 0)
		{
			ram = null;
		}
	}
	
	public boolean checkSocketType(CpuPart cpu, MotherboardPart motherboard)
	{
		if (cpu.getSocketType().compareTo(motherboard.getSocketType()) == 0)	// compares cpu and mb sockettype
		{
			return true;
		}
		return false;
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
	
	public boolean isThisCompatible()  // build is not compatible without having all the parts
	{
		if (cpu == null || mb == null || gpu == null || ram == null)
		{
			return false;
		}
		return true;
	}
}
