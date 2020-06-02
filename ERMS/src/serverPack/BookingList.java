package serverPack;

import java.util.ArrayList;
import java.util.Date;

public class BookingList {
	private ArrayList<Booking> bookingList;

	public BookingList() {
		bookingList = new ArrayList<Booking>();
	}

	public Response book(Booking bookingReq) {

		if (bookingReq.getBookingID() instanceof String && bookingReq.getFrom() instanceof Date
				&& bookingReq.getTo() instanceof Date && bookingReq.getUnitID() instanceof String
				&& bookingReq.getVenueID() instanceof String
				&& Float.valueOf(bookingReq.getDiscount()) instanceof Float) {
			
			for(Venue venue: Server.venueList.getList()){
				if (venue.getID()==bookingReq.getVenueID()){
					for (Unit unit: venue.getUnits().getUnitList()){
						if(!unit.isBooked()){
							bookingList.add(bookingReq);
							unit.setBooked(true);
							return new Response(true, "booking request completed successfully");
						}
					}
					return new Response(false, "booking request failed, venue found, but unit is booked already");
				}
			}
			return new Response(false, "booking request failed, venue not found");
			
		} else {
			return new Response(false, "booking request failed, elements are invalid");
		}
	}

	public Response modify(Booking bookingReq) {

		if (bookingReq.getBookingID() instanceof String && bookingReq.getFrom() instanceof Date
				&& bookingReq.getTo() instanceof Date && bookingReq.getUnitID() instanceof String
				&& bookingReq.getVenueID() instanceof String
				&& Float.valueOf(bookingReq.getDiscount()) instanceof Float) {

			for (Booking booking : bookingList) {
				if (booking.getBookingID() == bookingReq.getBookingID()) {
					cancel(bookingReq.getBookingID());
					book(bookingReq);
					return new Response(true, "booking modify request completed successfully");
				}
			}
			return new Response(false, "booking not found");

		} else {
			return new Response(false, "booking request elements are invalid");
		}

	}

	public Response cancel(String bookingID) {
		for (Booking booking : bookingList) {
			if (booking.getBookingID() == bookingID) {
				bookingList.remove(booking);
				for (Venue venue: Server.venueList.getList()){
					if(venue.getID()==booking.getVenueID()){
						for (Unit unit: venue.getUnits().getUnitList()){
							if (unit.getUnitID()==booking.getUnitID()){
								unit.setBooked(false);
							}
						}
					}
				}
				return new Response(true, "booking cancellation completed successfully");
			}
		}
		return new Response(false, "booking not found");
	}
	
	@Override
	public String toString(){
		String output="";
		for(Booking bking:bookingList){
			output+=bking.toString()+"\n";
		}
		return output;
	}
	
	
	
	public ArrayList<Booking> getBookings() {
		return bookingList;
	}

	public void setBookings(ArrayList<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	public Booking getBookingByID(String bookingID){
		for(Booking bking: bookingList)
			if (bking.getBookingID().equals(bookingID))
				return bking;
		return null;
	}

}
