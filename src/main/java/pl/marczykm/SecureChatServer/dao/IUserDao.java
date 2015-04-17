package pl.marczykm.SecureChatServer.dao;

import pl.marczykm.SecureChatServer.entity.User;

public interface IUserDao {
	public User findUserBy(String username);
	
}
