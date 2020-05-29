package serverPack;
import java.util.Arrays;

public class Venue {
	private int ID;
	private String type;
	private String instance;
	private Unit[] units;

	public Venue(int ID, String type, String instance, Unit[] units) {
		this.ID = ID;
		this.type = type;
		this.instance = instance;
		this.units = units;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public Unit[] getUnits() {
		return units;
	}

	public void setUnits(Unit[] units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "Venue [ID=" + ID + ", Type=" + type + ", Instance=" + instance + ", Units=" + Arrays.toString(units)
				+ "]";
	}

}
