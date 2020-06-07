package theater;

import java.io.Serializable;

import serverPack.*;

//this is a venue data structure
//extended to a theater
//as an example and showcase of the power of our system

public class Theater extends Venue implements Serializable {
	
	private static final long serialVersionUID = 8358300064732856674L;
	final static String venueType = "Theater";

	public Theater(String ID, int capacity, String instance) {
		super(ID, capacity, venueType, instance);

	}

	@Override
	public int getCapacity() {
		return super.getCapacity();
	}

	@Override
	public void setCapacity(int capacity) {
		super.setCapacity(capacity);
	}

	@Override
	public String getVenueID() {
		return super.getVenueID();
	}

	@Override
	public void setVenueID(String ID) {
		super.setVenueID(ID);
	}

	@Override
	public String getType() {
		return super.getType();
	}

	@Override
	public void setType(String type) {
		super.setType(type);
	}

	@Override
	public String getInstance() {
		return super.getInstance();
	}

	@Override
	public void setInstance(String instance) {
		super.setInstance(instance);
	}

	@Override
	public UnitList getUnits() {
		return super.getUnits();
	}

	@Override
	public void setUnits(UnitList units) {
		super.setUnits(units);
	}

	@Override
	public String toString() {
		return "Theater [ID=" + super.getVenueID() + ", Capacity=" + super.getCapacity() + ", Type=" + venueType
				+ ", Instance=" + super.getInstance() + ", Units=" + super.getUnits().size() + "]";
	}

}
