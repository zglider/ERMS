package serverPack;

import java.io.Serializable;

//this is the basic data structure class for the units
public class Unit implements Serializable{
	
	private static final long serialVersionUID = 5552946751922833886L;
	private String unitID;
	private String venueID;
	private String tier;
	private float price;
	private boolean booked;

	public Unit(String unitID, String venueID, String tier, float price, boolean booked) {
		this.unitID = unitID;
		this.venueID = venueID;
		this.tier = tier;
		this.price = price;
		this.booked = booked;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
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

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Unit [UnitID=" + unitID + ", VenueID=" + venueID + ", Tier=" + tier + ", Price=" + price + ", Booked="
				+ booked + "]";
	}

}
