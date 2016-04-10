package partPickerPC;

public class User 
{
	
	//name and password values
	private int userId;
	private String name;
	private String password;
	
	//constructor
	public User()
	{
		
	}
	public User(String name, String password){
		this.name = name;
		this.password = password;
	}
	
	//return value of name
	public String getName(){
		return name;
	}
	
	//return value of password
	public String getPassword(){
		return password;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
