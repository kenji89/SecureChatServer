package pl.marczykm.SecureChatServer.service;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import pl.marczykm.SecureChatServer.dao.impl.UserDao;
import pl.marczykm.SecureChatServer.entity.User;
import pl.marczykm.SecureChatServer.helper.UserConverter;
import pl.marczykm.SecureChatServer.helper.UserHelper;

public class UserServiceTest {

	@Mock
	private UserDao userDao = Mockito.mock(UserDao.class);
	
	@InjectMocks
	IUserService userService = new UserService(userDao);
	
	private final User TEST_USER = new User("test_user", UserHelper.hashPassword("password123"));
		
	@Test
	public void testRegister() throws Throwable{		
		Mockito.when(userDao.findOneByUsername(TEST_USER.getUsername())).thenReturn(null);
				
		User result = userService.register(UserConverter.userToAuthUserConvert(TEST_USER));
		
		Assert.assertEquals(result.toString(), TEST_USER.toString());
	}
	
	@Test
	public void testLogin() throws Throwable {		
		Mockito.when(userDao.findOneByUsername(TEST_USER.getUsername())).thenReturn(TEST_USER);
				
		User result = userService.login(TEST_USER.getUsername(), TEST_USER.getHashedPassword());
		
		Assert.assertEquals(result.toString(), TEST_USER.toString());
	}
}
