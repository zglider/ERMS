package serverPack;

import java.util.Date;

public class RequestIn {
	private int operation;
	private int venueID;
	private int unitID;
	private Date from;
	private Date to;
	private float discount;
	private String bookingID;

	public RequestIn(int operation, int venueID, int unitID, Date from, Date to, float discount, String bookingID) {

		this.operation = operation;
		this.venueID = venueID;
		this.unitID = unitID;
		this.from = from;
		this.to = to;
		this.discount = discount;
		this.bookingID=bookingID;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public int getVenueID() {
		return venueID;
	}

	public void setVenueID(int venueID) {
		this.venueID = venueID;
	}

	public int getUnitID() {
		return unitID;
	}

	public void setUnitID(int unitID) {
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

	@Override
	public String toString() {
		return "Request [Operation=" + operation + ", VenueID=" + venueID + ", UnitID=" + unitID + ", From=" + from
				+ ", To=" + to + ", Discount=" + discount + "]";
	}

	public Response process() {
		Response response = null;
		switch (this.operation) {
		case (0):
			Booking newBooking = new Booking(this.bookingID, this.from, this.to, this.unitID,
					this.venueID, this.discount);
			response = Server.bookingList.book(newBooking);
			break;
		case (1):
			Booking modifyBooking = new Booking(this.bookingID, this.from, this.to, this.unitID,
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
