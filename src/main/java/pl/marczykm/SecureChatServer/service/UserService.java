package pl.marczykm.SecureChatServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.marczykm.SecureChatServer.dao.impl.UserDao;
import pl.marczykm.SecureChatServer.entity.AuthenticatingUser;
import pl.marczykm.SecureChatServer.entity.User;
import pl.marczykm.SecureChatServer.exceptions.TechnicalException;

@RestController
@RequestMapping("/user")
public class UserService implements IUserService {

	private UserDao userDao;

	@Autowired
	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User register(@RequestBody(required = true) AuthenticatingUser user) throws TechnicalException {
		User foundUser = userDao.findOneByUsername(user.getUsername());
		if (foundUser != null)
			throw new TechnicalException("User already exists");

		User newUser = new User(user.getUsername(), user.getHashedPassword());
		userDao.save(newUser);
		return newUser;
	}

	@Override
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(@RequestParam(required = true) String username,
			@RequestParam(required = true) String hashedPassword) throws Throwable {
		User foundUsers = userDao.findOneByUsername(username);
		if (foundUsers == null)
			throw new TechnicalException("User not found");
		if (!foundUsers.getHashedPassword().equals(hashedPassword))
			throw new TechnicalException("Password does not match");
		return foundUsers;
	}

}
