package serverPack;

import java.util.Date;

public class RequestIn {
	private int operation;
	private String venueID;
	private String unitID;
	private String customer;
	private Date from;
	private Date to;
	private float discount;
	private String bookingID;

	public RequestIn(int operation, String venueID, String unitID, String customer, Date from, Date to, float discount,
			String bookingID) {

		this.operation = operation;
		this.venueID = venueID;
		this.unitID = unitID;
		this.customer = customer;
		this.from = from;
		this.to = to;
		this.discount = discount;
		this.bookingID = bookingID;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public String getVenueID() {
		return venueID;
	}

	public void setVenueID(String venueID) {
		this.venueID = venueID;
	}

	public String getUnitID() {
		return unitID;
	}

	public void setUnitID(String unitID) {
		this.unitID = unitID;
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

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	@Override
	public String toString() {
		return "Request [Operation=" + operation + ", VenueID=" + venueID + ", UnitID=" + unitID + ", From=" + from
				+ ", To=" + to + ", Discount=" + discount + "]";
	}

	public Response process() {
		Response response = null;
		switch (this.operation) {
		case (0):
			Booking newBooking = new Booking(this.bookingID, this.customer, this.from, this.to, this.unitID,
					this.venueID, this.discount);
			response = Server.bookingList.book(newBooking);
			break;
		case (1):
			Booking modifyBooking = new Booking(this.bookingID, this.customer, this.from, this.to, this.unitID,
					this.venueID, this.discount);
			response = Server.bookingList.modify(modifyBooking);
			break;
		case (2):
			String cancelBooking = this.bookingID;
			response = Server.bookingList.cancel(cancelBooking);
			break;
		default:
			break;
		}
		return response;
	}

}
