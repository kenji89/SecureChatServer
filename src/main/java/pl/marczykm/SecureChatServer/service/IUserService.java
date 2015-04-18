package pl.marczykm.SecureChatServer.service;

import pl.marczykm.SecureChatServer.entity.AuthenticatingUser;
import pl.marczykm.SecureChatServer.entity.User;
import pl.marczykm.SecureChatServer.exceptions.TechnicalException;

public interface IUserService {
	public User register(AuthenticatingUser user) throws TechnicalException;
	public User login(String username, String hashedPassword) throws Throwable;
}
