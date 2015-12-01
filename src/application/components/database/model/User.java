package application.components.database.model;

public class User {

	@SuppressWarnings("unused")
	private static final String TABLE_ID = "user";
	
	private String username;
	
	private String password;
	
	private String hashInfo = null;
	
	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashInfo() {
		return hashInfo;
	}

	public void setHashInfo(String hashInfo) {
		this.hashInfo = hashInfo;
	}
	
	public void save(String username, String hashInfo) {
		
	}
	public boolean exists(String username) {
		
		return false;
	}
}
