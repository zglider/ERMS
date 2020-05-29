package serverPack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {

	static VenueList venueList;
	static BookingList bookingList;

	public static void main(String[] args) {
		final int serverPort = 50005;
		init();

		try {
			venueList = new VenueList();
			bookingList = new BookingList();
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(serverPort);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				new ServerService(clientSocket);
			}
		} catch (IOException e) {
			System.out.println("Debug: Server: server socket failure");
			e.printStackTrace();

		}

	}

	public static void init() {

		// Initialising some avenues along with units in them

		// the Waldorf, a hotel with 10 rooms
		UnitList waldorfUnits = new UnitList();
		String waldorfID = UUID.randomUUID().toString();
		for (int i = 1; i <= 10; i++) {
			if ((i % 2) == 0) {
				waldorfUnits.addUnit(new Unit(UUID.randomUUID().toString(), waldorfID, "Standard", 500, false));
			} else {
				waldorfUnits.addUnit(new Unit(UUID.randomUUID().toString(), waldorfID, "Suite", 1200, false));
			}
		}
		venueList.addVenue(new Venue(waldorfID, 10, "Hotel", "Waldorf", waldorfUnits));

		// An airliner flight, with 50 seats
		UnitList flyDubaiUnits = new UnitList();
		String flyDubaiID = UUID.randomUUID().toString();
		for (int i = 1; i <= 50; i++) {
			if ((i % 2) == 0 && i >= 40) {
				flyDubaiUnits.addUnit(new Unit(UUID.randomUUID().toString(), flyDubaiID, "First Class", 2500, false));
			} else {
				flyDubaiUnits.addUnit(new Unit(UUID.randomUUID().toString(), flyDubaiID, "Economy", 800, false));
			}
		}
		venueList.addVenue(new Venue(flyDubaiID, 10, "Fly Dubai", "FD200", flyDubaiUnits));

	}

}
