package serverPack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerService extends Thread {

	ObjectInputStream in;
	ObjectOutputStream out;
	Socket clientSocket;

	public ServerService(Socket clientSocket) {
		try {
			this.clientSocket = clientSocket;
			in = new ObjectInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			this.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Debug: ServerService: Client socket failure");
		}
	}
	
	public void run(){
		Response response = null;
		try {
			Request request = (Request) in.readObject();
			response = request.process();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
			System.out.println("Debug: ServerService Run: request reception issue");
		}
		
		
		try {
			out.writeObject(response);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Debug: Server Service Run: response issue");
		}
	}

}
