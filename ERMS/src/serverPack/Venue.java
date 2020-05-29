package serverPack;

public class Venue {
	private String ID;
	private int capacity;
	private String type;
	private String instance;
	private UnitList units;

	public Venue(String ID, int capacity, String type, String instance, UnitList units) {
		this.ID = ID;
		this.capacity = capacity;
		this.type = type;
		this.instance = instance;
		this.units = units;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
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

}
