package serverPack;

import java.util.ArrayList;

public class BookingList {
	private ArrayList<Booking> bookingList;

	public BookingList() {
		bookingList = new ArrayList<Booking>();
	}

	public Response book(Booking bookingReq) {
		for (Venue venue : Server.venueList.getList()) {
			if (venue.getID() == bookingReq.getVenueID()) {
				for (Unit unit : venue.getUnits().getUnitList()) {
					if (unit.getUnitID() == bookingReq.getUnitID()) {
						if (!unit.isBooked()) {
							bookingList.add(bookingReq);
							unit.setBooked(true);
							return new Response(true, "booking request completed successfully");
						} else {
							return new Response(false,
									"booking request failed, venue & unit found, but unit is booked already");
						}
					}
				}
				return new Response(false, "booking request failed, venue found, but unit wasn't found");
			}
		}
		return new Response(false, "booking request failed, venue not found");
	}

	public Response modify(Booking bookingReq) {
		for (Booking booking : bookingList) {
			if (booking.getBookingID() == bookingReq.getBookingID()) {
				cancel(bookingReq.getBookingID());
				book(bookingReq);
				return new Response(true, "booking modify request completed successfully");
			}
		}
		return new Response(false, "booking not found");
	}

	public Response cancel(String bookingID) {
		for (Booking booking : bookingList) {
			if (booking.getBookingID() == bookingID) {
				bookingList.remove(booking);
				Server.venueList.getVenueByID(booking.getVenueID()).getUnits().getUnitByID(booking.getUnitID()).setBooked(false);
				return new Response(true, "booking cancellation completed successfully");
			}
		}
		return new Response(false, "booking not found");
	}

	@Override
	public String toString() {
		String output = "";
		for (Booking bking : bookingList) {
			output += bking.toString() + "\n";
		}
		return output;
	}

	public ArrayList<Booking> getBookings() {
		return bookingList;
	}

	public void setBookings(ArrayList<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	public Booking getBookingByID(String bookingID) {
		for (Booking bking : bookingList)
			if (bking.getBookingID().equals(bookingID))
				return bking;
		return null;
	}

}
