package theater;

import serverPack.*;

public class Theater extends Venue {
	final static String venueType = "Theater";

	public Theater(String ID, int capacity, String instance, UnitList units) {
		super(ID, capacity, venueType, instance, units);

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
	public String getID() {
		return super.getID();
	}

	@Override
	public void setID(String ID) {
		super.setID(ID);
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
		return "Theater [ID=" + super.getID() + ", Capacity=" + super.getCapacity() + ", Type=" + venueType
				+ ", Instance=" + super.getInstance() + ", Units=" + super.getUnits().size() + "]";
	}

}
