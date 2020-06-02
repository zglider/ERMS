package serverPack;

import java.util.Date;

public class Booking {
	private String bookingID;
	private String customer;
	private Date from;
	private Date to;
	private String unitID;
	private String venueID;
	private float discount;

	public Booking(String bookingID, String customer, Date from, Date to, String unitID, String venueID,
			float discount) {
		this.bookingID = bookingID;
		this.customer = customer;
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

	public String getUnitID() {
		return unitID;
	}

	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}

	public String getVenueID() {
		return venueID;
	}

	public void setVenueID(String venueID) {
		this.venueID = venueID;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Booking [BookingID=" + bookingID +", Customer=" + customer + ", From=" + from + ", To=" + to + ", UnitID=" + unitID + ", VenueID="
				+ venueID + ", Discount=" + discount * 100 + "%]";
	}

}
