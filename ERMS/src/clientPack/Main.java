package clientPack;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import serverPack.Booking;
import serverPack.Unit;
import serverPack.Venue;
import serverPack.Request;

public class Main {
	static ArrayList<Request> requestQueue;

	public static void main(String[] args) {
		requestQueue = new ArrayList<Request>();
		String rotanaHotelID = "rotanaHotelID";
		String rotanaRoomID = "rotanaRoomID";

		//queueing some requests
		requestQueue.add(new Request(0, "Venue", new Venue(rotanaHotelID, 12, "Hotel", "Beach Rotana")));
		requestQueue.add(new Request(0, "Unit", new Unit(rotanaRoomID, rotanaHotelID, "Beach View", 450, false)));
		requestQueue.add(new Request(0, "Booking", new Booking(UUID.randomUUID().toString(), "Omar",
				new Date(2020, 7, 5), new Date(2020, 7, 9), rotanaHotelID, rotanaRoomID, 0.1f)));
		
		//running a thread to push the requests to the server
		new Client();

	}

}
