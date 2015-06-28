package pl.marczykm.SecureChatServer.entity;

public class AuthenticatingUser {
	private String username;
	private String hashedPassword;

	public AuthenticatingUser() {
	}

	public AuthenticatingUser(String username, String hashedPassword) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	public String getHashedPassword() {
		return hashedPassword;
	}
}
