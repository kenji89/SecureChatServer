package pl.marczykm.SecureChatServer.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import pl.marczykm.SecureChatServer.helper.UserHelper;

@Document(collection = "users")
public class User {
	@Id
	private String id;
	private String username;
	private String hashedPassword;

	private List<User> friends;

	public User() {
		friends = new ArrayList<User>();
	}

	public User(String username, String hashedPassword) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
		friends = new ArrayList<User>();
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.hashedPassword = UserHelper.hashPassword(password);
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public List<User> getFriends() {
		return friends;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result
				+ ((hashedPassword == null) ? 0 : hashedPassword.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (hashedPassword == null) {
			if (other.hashedPassword != null)
				return false;
		} else if (!hashedPassword.equals(other.hashedPassword))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username
				+ ", hashedPassword=" + hashedPassword + ", friends=" + friends
				+ "]";
	}
	
	
	
	
}
