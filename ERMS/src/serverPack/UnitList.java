package serverPack;

import java.util.ArrayList;

public class UnitList {
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

	public Response addUnit(Unit unitReq) {
		for (Venue venue : Server.venueList.getList()) {
			if (venue.getID() == unitReq.getVenueID()) {
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

	public Response modifyUnit(Unit unitReq) {
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
}
