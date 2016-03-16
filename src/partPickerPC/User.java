package partPickerPC;

public class User 
{
	private char name;
	private char password;
	
	public void User(name, password){
		this.name = name;
		this.password = password;
	}
	
	public char getName(){
		
		return User.name;
	}
	
	public char getPassword(){
		
		return User.password;
	}
}
