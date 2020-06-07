package theater;

import java.io.Serializable;

import serverPack.*;

//this is a unit extension
//as an example and showcase of the extensibility of our system
public class TheaterSeat extends Unit implements Serializable {
	
	private static final long serialVersionUID = 6826596810911636907L;
	boolean wheelchairAccess = false;

	public TheaterSeat(String unitID, String venueID, String tier, float price, boolean booked,
			boolean wheelchairAccess) {
		super(unitID, venueID, tier, price, booked);
		this.wheelchairAccess = wheelchairAccess;
	}

	@Override
	public boolean isBooked() {
		return super.isBooked();
	}

	@Override
	public void setBooked(boolean booked) {
		super.setBooked(booked);
	}

	@Override
	public String getVenueID() {
		return super.getVenueID();
	}

	@Override
	public void setVenueID(String venueID) {
		super.setVenueID(venueID);
	}

	@Override
	public String getUnitID() {	
		return super.getUnitID();
	}

	@Override
	public void setUnitID(String unitID) {
		super.setUnitID(unitID);
	}

	@Override
	public String getTier() {
		return super.getTier();
	}

	@Override
	public void setTier(String tier) {	
		super.setTier(tier);
	}

	@Override
	public float getPrice() {	
		return super.getPrice();
	}

	@Override
	public void setPrice(float price) {
		super.setPrice(price);
	}
	
	public boolean isWheelchairAccess() {
		return wheelchairAccess;
	}

	public void setWheelchairAccess(boolean wheelchairAccess) {
		this.wheelchairAccess = wheelchairAccess;
	}

	@Override
	public String toString() {
		return "TheaterSeat [UnitID=" + super.getUnitID() + ", VenueID=" + super.getVenueID()+ ", Tier=" + super.getTier() + ", Price=" + super.getPrice() + ", Booked="
				+ super.isBooked() +", Wheelchair Access="+ wheelchairAccess + "]";
	}

}
