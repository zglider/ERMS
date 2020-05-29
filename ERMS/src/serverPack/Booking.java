package serverPack;

import java.util.Date;

public class Booking {
	private String bookingID;
	private Date from;
	private Date to;
	private int unitID;
	private int venueID;
	private float discount;
	

	public Booking(String bookingID, Date from, Date to, int unitID, int venueID, float discount) {
		this.bookingID = bookingID;
		this.from = from;
		this.to = to;
		this.unitID = unitID;
		this.venueID = venueID;
		this.discount = discount;
	}

		
	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public int getUnitID() {
		return unitID;
	}

	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

	public int getVenueID() {
		return venueID;
	}

	public void setVenueID(int venueID) {
		this.venueID = venueID;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Booking [BookingID=" + bookingID + ", From=" + from + ", To=" + to + ", UnitID=" + unitID + ", VenueID="
				+ venueID + ", Discount=" + discount * 100 + "%]";
	}

}
