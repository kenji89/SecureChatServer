package pl.marczykm.SecureChatServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server extends Thread {

	public static void main(String[] args) {
		SpringApplication.run(Server.class, args);
	}
}
