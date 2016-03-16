package partPickerPC;

public class User 
{
	//name and password values
	private String name;
	private String password;
	
	//constructor
	public void User(String name, String password){
		this.name = name;
		this.password = password;
	}
	
	//return value of name
	public String getName(){
		
		return User.name;
	}
	
	//return value of password
	public String getPassword(){
		
		return User.password;
	}
}
