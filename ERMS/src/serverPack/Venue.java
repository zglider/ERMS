package serverPack;

import java.io.Serializable;

//this is the data strucuture class for the venues
public class Venue implements Serializable{
	
	private static final long serialVersionUID = 3971103198395034887L;
	private String ID;
	private int capacity;
	private String type;
	private String instance;
	private UnitList units;

	public Venue(String ID, int capacity, String type, String instance) {
		this.ID = ID;
		this.capacity = capacity;
		this.type = type;
		this.instance = instance;
		this.units = new UnitList();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getVenueID() {
		return ID;
	}

	public void setVenueID(String ID) {
		this.ID = ID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public UnitList getUnits() {
		return units;
	}

	public void setUnits(UnitList units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "Venue [ID=" + ID + ", Capacity=" + capacity + ", Type=" + type + ", Instance=" + instance + ", Units="
				+ units.size() + "]";
	}
	
	public double getOccupancy(){
		int bookedUnits=0;
		for (Unit unit: units.getUnitList()){
			if(unit.isBooked())
				bookedUnits++;
		}
		return (double)bookedUnits/(double)this.capacity;
	}

}
