package partPickerPC;
import java.util.ArrayList;

public class Cart {
	
	//list for a user's cart
	
	//add a part to the cart
	public void addPart(Part part){
		cart.add(part);
	}
	
	//return parts from the list
	public ArrayList<Part> getCart(){
		return cart;
	}
	
	//remove a part from the list
	public void removePart(int num){
		//this assumes the value is entered with values starting as one
		//ie if an item was 1 it would be 0 in the arraylist
		num = num - 1;
		cart.remove(num);
	}
	
	//this is in case we want to clear carts for users instead of creating a new one
	//such as when a user "checks out" or something similar
	public void removeAll(){
		for(int i = 0; i < cart.size(); i++){
			cart.remove(i);
		}
	}
	
}
