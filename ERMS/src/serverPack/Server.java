package serverPack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static BookingList bookingList;
	
	public static void main(String[] args) {
		final int serverPort = 50005;
		

		try {
			bookingList = new BookingList();
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(serverPort);
			while (true){
				Socket clientSocket = serverSocket.accept();
				new ServerService(clientSocket);
			}
		} catch (IOException e) {
			System.out.println("Debug: Server: server socket failure");
			e.printStackTrace();
			
		} 

	}

}
