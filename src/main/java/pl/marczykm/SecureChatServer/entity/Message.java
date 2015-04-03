package pl.marczykm.SecureChatServer.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private User sender;
	private User receiver;
	private String content;
	private Date creationDate;
	private boolean read;

	public Message() {
	}

	public User getSender() {
		return sender;
	}

	@XmlElement
	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	@XmlElement
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	@XmlElement
	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	@XmlElement
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isRead() {
		return read;
	}

	@XmlElement
	public void setRead(boolean read) {
		this.read = read;
	}

}
