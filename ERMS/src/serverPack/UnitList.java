package serverPack;

import java.io.Serializable;
import java.util.ArrayList;

//this is the table class for the unit data structure
public class UnitList extends ItemList implements Serializable{
	
	private static final long serialVersionUID = -8541998498541671889L;
	private ArrayList<Unit> unitList;

	public ArrayList<Unit> getUnitList() {
		return unitList;
	}

	public void setUnitList(ArrayList<Unit> unitList) {
		this.unitList = unitList;
	}

	public UnitList() {
		unitList = new ArrayList<Unit>();
	}

	public Response addItem(Unit unitReq) {
		for (Venue venue : Server.venueList.getList()) {
			if (venue.getVenueID() == unitReq.getVenueID()) {
				if (venue.getUnits().size() >= venue.getCapacity()) {
					return new Response(false, "Add unit failed, venue is full");
				} else {
					unitList.add(unitReq);
					return new Response(true, "Add unit request succeeded");
				}
			}
		}
		return new Response(false, "Venue not found");
	}

	public Response modifyItem(Unit unitReq) {
		for (Unit unit : unitList) {
			if (unit.getUnitID() == unitReq.getUnitID()) {
				unitList.set(unitList.indexOf(unit), unitReq);
				return new Response(true, "Unit modified successfully");
			}
		}
		return new Response(false, "Unit not found");
	}

	public Response removeUnit(String unitID) {
		for (Unit unit : unitList) {
			if (unit.getUnitID() == unitID) {
				if (!unit.isBooked()) {
					unitList.remove(unit);
					return new Response(true, "Unit removed successfully");
				} else {
					return new Response(false, "Unit cannnot be removed, it's booked");
				}
			}
		}
		return new Response(false, "Unit not found");
	}

	public int size() {
		return unitList.size();
	}

	public String getFirstAvailable() {
		for (Unit unit : unitList) {
			if (unit.isBooked() == false) {
				return unit.getUnitID();
			}
		}
		return "No vacancy";
	}

	public Unit getUnitByID(String unitIDReq) {
		for (Unit unit : unitList) {
			if (unit.getUnitID() == unitIDReq) {
				return unit;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String output = "";
		for (Unit unit : unitList) {
			output += unit.toString();
		}
		return output;
	}
	
	public Response processRequest(Request req){
		switch (req.getOperation()) {
		case (0):
			return addItem((Unit)req.getListItem());
		case (1):
			return modifyItem((Unit)req.getListItem());
		case (2):
			return removeItem(((Unit) (req.getListItem())).getUnitID());
		default:
			break;
		}
		return null;
	}
}
