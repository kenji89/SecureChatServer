package pl.marczykm.SecureChatServer.helper;

import pl.marczykm.SecureChatServer.entity.AuthenticatingUser;
import pl.marczykm.SecureChatServer.entity.User;

public class UserConverter {
	
	public static AuthenticatingUser userToAuthUserConvert(User user){
		AuthenticatingUser authUser = new AuthenticatingUser();
		authUser.setUsername(user.getUsername());
		authUser.setHashedPassword(user.getHashedPassword());
		
		return authUser;
	}
}
