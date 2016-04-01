package Parts;

import partPickerPC.PartInterface;

public class StoragePart implements PartInterface {
	private String capacity;
	private String storageType;
	private String dataSpeed;
	private String url;
	private String brand;
	private String model;
	private double price;
	private double sale;
	
	public StoragePart(String capacity, String storageType, String dataSpeed, String url, String brand, String model, double price, double sale){
		this.capacity = capacity;
		this.storageType = storageType;
		this.dataSpeed = dataSpeed;
		this.url = url;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.sale = sale;
	}
	
	public String getCapacity(){
		return capacity;
	}
	
	public String getStorageType(){
		return storageType;
	}
	
	public String getdataSpeed(){
		return dataSpeed;
	}
	
	public String getUrl(){
		return url;
	}
	
	public String getBrand(){
		return brand;
	}
	
	public String getModel(){
		return model;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double updatedPrice){
		this.price = updatedPrice;
	}
	
}
