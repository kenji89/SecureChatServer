package pl.marczykm.SecureChatServer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String username;
	private String password;
	
	private List<User> friends;
	
	public User() {
	}
	

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		friends = new ArrayList<User>();
	}


	public String getUsername() {
		return username;
	}

	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getFriends() {
		return friends;
	}

	@XmlElementWrapper(name="friends")
	@XmlElement(name = "friend")
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	
}
