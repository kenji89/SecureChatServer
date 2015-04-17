package pl.marczykm.SecureChatServer.dao.impl;

import pl.marczykm.SecureChatServer.dao.IUserDao;
import pl.marczykm.SecureChatServer.entity.User;

public class UserDao implements IUserDao{
	public User findUserBy(String username){
		User user = new User(username, "dupa");
		return user;
	}
}
