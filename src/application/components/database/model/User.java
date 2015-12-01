package application.components.database.model;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {

	/** The Constant TABLE_ID. */
	@SuppressWarnings("unused")
	private static final String TABLE_ID = "user";
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The hash info. */
	private String hashInfo = null;
	
	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the hash info.
	 *
	 * @return the hash info
	 */
	public String getHashInfo() {
		return hashInfo;
	}

	/**
	 * Sets the hash info.
	 *
	 * @param hashInfo the new hash info
	 */
	public void setHashInfo(String hashInfo) {
		this.hashInfo = hashInfo;
	}
	
	/**
	 * Save.
	 *
	 * @param username the username
	 * @param hashInfo the hash info
	 */
	public void save(String username, String hashInfo) {
		
	}
	
	/**
	 * Exists.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean exists(String username) {
		
		return false;
	}
}
