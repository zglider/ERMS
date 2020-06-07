package serverPack;

import java.util.ArrayList;

//this class handles the bookings table
public class BookingList extends ItemList {
	private ArrayList<Booking> bookingList;

	public BookingList() {
		bookingList = new ArrayList<Booking>();
	}
	
	public Response addItem(Booking bookingReq) {
		for (Venue venue : Server.venueList.getList()) {
			if (venue.getVenueID() == bookingReq.getVenueID()) {
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

	public Response modifyItem(Booking bookingReq) {
		for (Booking booking : bookingList) {
			if (booking.getBookingID() == bookingReq.getBookingID()) {
				removeItem(bookingReq.getBookingID());
				addItem(bookingReq);
				return new Response(true, "booking modify request completed successfully");
			}
		}
		return new Response(false, "booking not found");
	}

	public Response removeItem(String bookingID) {
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
	
	public Response processRequest(Request req){
		switch (req.getOperation()) {
		case (0):
			return addItem((Booking)req.getListItem());
		case (1):
			return modifyItem((Booking)req.getListItem());
		case (2):
			return removeItem(((Booking) (req.getListItem())).getBookingID());
		default:
			break;
		}
		return null;
	}


}
