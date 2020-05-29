package serverPack;

import java.util.ArrayList;
import java.util.Date;

public class BookingList {
	private ArrayList<Booking> bookingList;
	public BookingList(){
		bookingList = new ArrayList<Booking>();
	}
	public Response book(Booking bookingReq) {
		

		if (bookingReq.getBookingID() instanceof String && bookingReq.getFrom() instanceof Date && bookingReq.getTo() instanceof Date
				&& Integer.valueOf(bookingReq.getUnitID()) instanceof Integer
				&& Integer.valueOf(bookingReq.getVenueID()) instanceof Integer
				&& Float.valueOf(bookingReq.getDiscount()) instanceof Float) {
			bookingList.add(bookingReq);
			return new Response(true, "booking request completed successfully");
		} else {
			return new Response(false, "booking request elements are invalid");
		}
	}


	public Response modify(Booking bookingReq) {
		Response response = null;

		if (bookingReq.getBookingID() instanceof String && bookingReq.getFrom() instanceof Date && bookingReq.getTo() instanceof Date
				&& Integer.valueOf(bookingReq.getUnitID()) instanceof Integer
				&& Integer.valueOf(bookingReq.getVenueID()) instanceof Integer
				&& Float.valueOf(bookingReq.getDiscount()) instanceof Float) {
			
			for (Booking booking: bookingList){
				if (booking.getBookingID()==bookingReq.getBookingID()){
					bookingList.set(bookingList.indexOf(booking), bookingReq);
					return response = new Response(true, "booking request completed successfully");
				}
				else{
					return response = new Response(false, "booking not found");
				}
			}
			
			
		} else {
			return response = new Response(false, "booking request elements are invalid");
		}

		return response;
	}

	
	public Response cancel(String bookingID) {
		Response response = null;

		for (Booking booking: bookingList){
			if (booking.getBookingID()==bookingID){
				bookingList.remove(booking);
				response = new Response(true, "booking cancellation completed successfully");
			}
			else{
				response = new Response(false, "booking not found");
			}
		}

		return response;
	}
	
}
