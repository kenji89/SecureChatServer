package pl.marczykm.SecureChatServer.helper;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import pl.marczykm.SecureChatServer.entity.User;

public class JAXBHelperTest {

	
	@Test
	public void generateStringTest() throws JAXBException{
		String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<user>\n"
				+ "    <friends>\n"
				+ "        <friend>\n"
				+ "            <friends/>\n"
				+ "            <password>456</password>\n"
				+ "            <username>User2</username>\n"
				+ "        </friend>\n"
				+ "    </friends>\n"
				+ "    <password>123</password>\n"
				+ "    <username>User1</username>\n"
				+ "</user>\n";
		User user1 = new User("User1", "123");
		User user2 = new User("User2", "456");
		
		user1.getFriends().add(user2);
		
		String generatedString = JAXBHelper.generateString(user1);
		
		assertEquals(generatedString, xmlContent);
	}
	
	@Test
	public void generateObjectTest() throws JAXBException{
		String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<user>\n"
				+ "    <friends>\n"
				+ "        <friend>\n"
				+ "            <friends/>\n"
				+ "            <password>456</password>\n"
				+ "            <username>User2</username>\n"
				+ "        </friend>\n"
				+ "    </friends>\n"
				+ "    <password>123</password>\n"
				+ "    <username>User1</username>\n"
				+ "</user>";
		User user1 = new User("User1", "123");
		User user2 = new User("User2", "456");
		
		user1.getFriends().add(user2);
		
		User generatedObject = JAXBHelper.generateObject(xmlContent, new User());
		
		assertEquals(generatedObject, user1);
	}
	
}
