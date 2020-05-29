package serverPack;

import java.util.Date;

public class Request {
	private int operation;
	private int venueID;
	private int unitID;
	private Date from;
	private Date to;
	private float discount;
	
	public Request(int operation, int venueID, int unitID, Date from, Date to, float discount) {
		
		this.operation = operation;
		this.venueID = venueID;
		this.unitID = unitID;
		this.from = from;
		this.to = to;
		this.discount = discount;
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
		switch(this.operation){
		case(0):
			break;
		case(1):
			break;
		case(2):
			break;
		default:
			break;
		}
		return response;
	}
	
	
	
}
