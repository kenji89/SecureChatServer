package pl.marczykm.SecureChatServer.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	private String id;
	private String username;
	private String hashedPassword;

	private List<User> friends;

	public User() {
	}

	public User(String username, String hashedPassword) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
		friends = new ArrayList<User>();
	}

	public String getUsername() {
		return username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public List<User> getFriends() {
		return friends;
	}

}
