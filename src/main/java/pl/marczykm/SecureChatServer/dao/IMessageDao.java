package pl.marczykm.SecureChatServer.dao;

import java.util.List;

import pl.marczykm.SecureChatServer.entity.Message;
import pl.marczykm.SecureChatServer.entity.User;

public interface IMessageDao {
	public List<Message> findBySender(User sender);
	public List<Message> findBySenderUnread(User sender);
	public List<Message> findByReceiver(User receiver);
	public List<Message> findByReceiverUnread(User receiver);
}
