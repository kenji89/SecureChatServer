package pl.marczykm.SecureChatServer.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.Assert;

public class UserHelper {
	public static byte[] hashPassword(String rawPassword) {
		byte[] hashedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(rawPassword.getBytes());
			hashedPassword = md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Assert.notNull(hashedPassword);
		return hashedPassword;
	}
}
