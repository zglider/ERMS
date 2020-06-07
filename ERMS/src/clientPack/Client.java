package clientPack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import serverPack.Request;
import serverPack.Response;

//this is the Clients core class
//starts a thread, and checks the queue
//and sends out the requests on the queue
//and gets their responses back
public class Client extends Thread {
	String host = "localhost";
	int serverPort = 50005;
	Socket s = null;
	ObjectInputStream in = null;
	ObjectOutputStream out = null;

	public Client() {

		System.out.println("ClientAdmin Accessed");

		try {
			s = new Socket(host, serverPort);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			this.start();
		} catch (IOException eIO) {
			System.out.println(eIO.getMessage());
			eIO.printStackTrace();
		}

	}

	public void run() {
		System.out.println("ClientAdmin run cycle beginning");
		while (true) {
			if (Main.requestQueue.size() > 0) {
				@SuppressWarnings("unchecked")
				ArrayList<Request> queueClone = (ArrayList<Request>) Main.requestQueue.clone();

				for (Request req : queueClone) {
					try {
						out.writeObject(req);
						System.out.println("ClientAdmin: Sending out a request: " + req.toString());
						Response response = (Response) in.readObject();
						System.out.println("ClientAdmin: Received a response: " + response.toString());

					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				Main.requestQueue.clear();
			}
		}
	}
}
