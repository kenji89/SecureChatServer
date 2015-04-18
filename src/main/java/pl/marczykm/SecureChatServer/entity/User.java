package pl.marczykm.SecureChatServer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue
	private String id;
	private String username;
	private String hashedPassword;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "friends", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "friend_id") })
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
