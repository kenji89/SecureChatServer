package pl.marczykm.SecureChatServer.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

	private String status;
	private String message;
	
	public Response() {
	}

	public Response(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}



	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	@XmlElement
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
