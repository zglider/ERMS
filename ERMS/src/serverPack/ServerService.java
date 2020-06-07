package serverPack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import serverPack.Request;

//this is the client handler class
//spawned by the server everytime it receives a client
public class ServerService extends Thread {

	ObjectInputStream in = null;
	ObjectOutputStream out = null;

	public ServerService(Socket clientSocket) {
		try {
			System.out.println("ServerService Accessed for: " + clientSocket.toString());
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
			this.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Debug: ServerService: Client socket failure");
		}
	}

	public void run() {
		
		Response response = null;
		Request request = null;
		while (true) {
			try {
				request = (Request) in.readObject();
				if (request != null) {
					System.out.println("Received request: " + request.toString());
					response = process(((Request) request));
					System.out.println("Sending out a response: " + response.toString());
					out.writeObject(response);
					request = null;
					response = null;
				}

			} catch (ClassNotFoundException | IOException e) {
				System.out.println("Debug: ServerService Run: request reception issue: " + e.getMessage());
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Response process(Request req) {
		switch (req.getListItemType()) {
		case ("Venue"):
			return Server.venueList.processRequest(req);
		case ("Unit"):
			return Server.venueList.getVenueByID(((Unit) req.getListItem()).getVenueID()).getUnits()
					.processRequest(req);
		case ("Booking"):
			return Server.bookingList.processRequest(req);
		default:
			break;
		}
		return null;
	}

}
