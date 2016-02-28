package partPickerPC;

import java.util.ArrayList;

public class Part 
{
	private ArrayList<String> attributes;  				//this list represents all of the traits the search class found.
	private String type; 								//is it a processor, gpu, etc.
	private double price; 								//cost
	private boolean isOnSale; 							//is it on sale
	private double salePercentage; 						//what is the percentage mark down of the sale
	
	public Part(){
		attributes = new ArrayList<String>();
	}
	
	public Part(String type, double price)
	{
		this.type = type;								// Just figured if a different obj was making this
		this.price = price;								// you might want this too since it's faster
		attributes = new ArrayList<String>();
	}
	public double getSalePercent(){						//GETTERS
		return this.salePercentage;
	}
	public double getPrice(){
		return price;
		}
	public String getType(){
		return this.type;
	}
	public boolean getSale(){
		return isOnSale;
	}
	public ArrayList<String> getAttr(){
		return this.attributes;
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
	public void setType(String s){
		this.type = s;
	}
	public void updateAttributes(String attr){
		this.attributes.add(attr);
	}
}
