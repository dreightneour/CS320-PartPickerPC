package partPickerPC;

import java.util.ArrayList;

public class Part 
{
	
	private double price; 								//cost
	private boolean isOnSale; 							//is it on sale
	private double salePercentage;						//what is the percentage mark down of the sale
	private String partType;
	
	public Part(){
	}
	
	public Part(double price)
	{													// Just figured if a different obj was making this
		this.price = price;								// you might want this too since it's faster
	}
	public double getSalePercent(){						//GETTERS
		return this.salePercentage;
	}
	public double getPrice(){
		return price;
		}

	public boolean getSale(){
		return isOnSale;
	}

	
	
	public void setPrice(double p){						//SETTERS
		this.price = p;
	}
	
	public void setSale(boolean condition){
		this.isOnSale = condition;
	}
	public void setSalePercentage(double percent){
		this.salePercentage = percent;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType)
	{
		this.partType = partType;
	}
	
	

}
