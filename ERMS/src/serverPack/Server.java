package serverPack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.UUID;

import theater.Theater;
import theater.TheaterSeat;

//The server thread to receive the clients requests
//and create threads for each client and process accordingly

public class Server {

	static VenueList venueList;
	static BookingList bookingList;

	public static void main(String[] args) {
		final int serverPort = 50005;

		try {
			venueList = new VenueList();
			bookingList = new BookingList();
			init();

			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(serverPort);
			 while (true) {
			 Socket clientSocket = serverSocket.accept();
			 System.out.println("Server: Got a new client, and about to start serving them: "+clientSocket.toString());
			 new ServerService(clientSocket);
			
			 }
		} catch (IOException e) {
			System.out.println("Debug: Server: server socket failure");
			e.printStackTrace();

		}

	}

	@SuppressWarnings("deprecation")
	public static void init() {

		// Initialising some avenues along with units in them

		// the Waldorf, a hotel with 10 rooms
		
		String waldorfID = UUID.randomUUID().toString();
		venueList.addItem(new Venue(waldorfID, 10, "Hotel", "Waldorf"));
		Venue waldorf = venueList.getVenueByID(waldorfID);
		for (int i = 1; i <= 10; i++) {
			if ((i % 2) == 0) {
				waldorf.getUnits().addItem(new Unit(UUID.randomUUID().toString(), waldorfID, "Standard", 500, false));
			} else {
				waldorf.getUnits().addItem(new Unit(UUID.randomUUID().toString(), waldorfID, "Suite", 1200, false));
			}
		}
		

		// An airliner flight, with 50 seats
		String flyDubaiID = UUID.randomUUID().toString();
		
		venueList.addItem(new Venue(flyDubaiID, 50, "Fly Dubai", "FD200"));
		Venue flyDubai = venueList.getVenueByID(flyDubaiID);
		for (int x = 1; x <= 50; x++) {
			if ((x % 2) == 0 && x >= 40) {
				flyDubai.getUnits().addItem(new Unit(UUID.randomUUID().toString(), flyDubaiID, "First Class", 2500, false));
			} else {
				flyDubai.getUnits().addItem(new Unit(UUID.randomUUID().toString(), flyDubaiID, "Economy", 800, false));
			}
		}
		

		System.out.println(venueList.toString());
		
		//
		// Booking a room in the Waldorf
		String roomToBook = venueList.getVenueByID(waldorfID).getUnits().getFirstAvailable();
		bookingList.addItem(new Booking(UUID.randomUUID().toString(), "Adam", new Date(2020, 5, 30), new Date(2020, 6, 6),
				roomToBook, waldorfID, 0.2f));

		System.out.println("Room: " + roomToBook + " is booked now? "
				+ venueList.getVenueByID(waldorfID).getUnits().getUnitByID(roomToBook).isBooked());
		System.out.println();

		// book an economy seat on Fly Dubai, then modify the booking
		String sampleBookingID = UUID.randomUUID().toString();
		for (Unit seat : venueList.getVenueByID(flyDubaiID).getUnits().getUnitList()) {
			if (!seat.isBooked() && seat.getTier() == "Economy") {
				bookingList.addItem(new Booking(sampleBookingID, "Zainab", new Date(2020, 7, 1), new Date(2020, 7, 15),
						seat.getUnitID(), seat.getVenueID(), 0.35f));
				break;
			}
		}
		System.out.println(bookingList.toString());

		// __Modify the booking
		Booking sampleBooking = bookingList.getBookingByID(sampleBookingID);
		bookingList.modifyItem(new Booking(sampleBookingID, "Zainab", new Date(2020, 9, 1), new Date(2020, 10, 15),
				sampleBooking.getUnitID(), sampleBooking.getVenueID(), 0.15f));
		System.out.println(bookingList.toString());
		System.out.println();

		// testing adding, modifying, and removing a unit
		// __Venue First
		String voxCinemaID = UUID.randomUUID().toString();
		venueList.addItem(new Venue(voxCinemaID, 5, "Cinema", "Vox"));
		Venue voxCinema = venueList.getVenueByID(voxCinemaID);

		// __Then add unit
		String sampleSeatID = UUID.randomUUID().toString();
		System.out.println(venueList.toString());
		voxCinema.getUnits().addItem(new Unit(sampleSeatID, voxCinemaID, "VIP", 75, false));
		System.out.println(voxCinema.getUnits().toString());

		// __Then modify unit
		voxCinema.getUnits().modifyItem(new Unit(sampleSeatID, voxCinemaID, "Standard", 50, false));
		System.out.println(voxCinema.getUnits().toString());

		// __then remove unit
		venueList.getVenueByID(voxCinemaID).getUnits().removeUnit(sampleSeatID);
		System.out.println(venueList.getVenueByID(voxCinemaID).getUnits().getUnitList().toString());

		// testing physical extension of the system
		// with a Theater inheritance of the Venue
		// and a TheaterSeat inheritance of the Unit
		// and showcasing the power of polymorphism in a project like ours
		String bolshoiID = UUID.randomUUID().toString();
		venueList.addItem(new Theater(bolshoiID, 20, "Swan Lake"));
		Venue bolshoi = venueList.getVenueByID(bolshoiID);
		bolshoi.getUnits()
				.addItem(new TheaterSeat(UUID.randomUUID().toString(), bolshoiID, "Gold Section", 400, false, true));

		System.out.println(venueList.toString());
		System.out.println(bolshoi.getUnits().toString());

		// show earned revenues
		double revenue = 0;
		for (Booking booking : bookingList.getBookings()) {
			revenue += (1.00 - booking.getDiscount()) * venueList.getVenueByID(booking.getVenueID()).getUnits()
					.getUnitByID(booking.getUnitID()).getPrice();
		}
		System.out.println();
		System.out.println("Earned revenues for all units in all venues= " + ((double) ((int) (revenue * 100))) / 100);

		// occupancy rate testing
		bookingList.addItem(new Booking(UUID.randomUUID().toString(), "Adel", new Date(2020, 1, 1), new Date(2020, 1, 5),
				bolshoi.getUnits().getFirstAvailable(), bolshoiID, 0.1f));
		System.out.println();
		System.out.println("Bolshoi Occupancy Rate: " + (int) (bolshoi.getOccupancy() * 100) + "%");
	}

}
