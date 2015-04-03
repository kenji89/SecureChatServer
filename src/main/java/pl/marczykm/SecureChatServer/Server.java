package pl.marczykm.SecureChatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import pl.marczykm.SecureChatServer.entity.User;
import pl.marczykm.SecureChatServer.helper.JAXBHelper;

/**
 * Hello world!
 *
 */
public class Server extends Thread {
	private ServerSocket serverSocket;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port "
						+ serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to "
						+ server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(
						server.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(
						server.getOutputStream());
				
				User user = new User();
				user.setUsername("marcin");
				user.setPassword("siemka");
				List<User> friends = new ArrayList<User>();
				friends.add(new User("ania", "asd"));
				user.setFriends(friends);
				
				out.writeUTF(JAXBHelper.generateString(user));
				server.close();
			} catch (SocketTimeoutException e) {
				System.err.println("Socket timed out!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		try {
			Thread t = new Server(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
