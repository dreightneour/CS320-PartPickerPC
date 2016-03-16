package partPickerPC;

public class User 
{
	//name and password values
	private String name;
	private String password;
	
	public void User(String name, String password){
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
