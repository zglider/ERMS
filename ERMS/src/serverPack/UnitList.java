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
		Response response = null;
		boolean venueFound = false;
		boolean full = false;
		for (Venue venue : Server.venueList.getList()) {

			if (venue.getID() == unitReq.getVenueID()) {
				venueFound = true;
				if (venue.getUnits().size() >= venue.getCapacity()) {
					full = true;
				}
			}

		}
		if (venueFound) {
			if (!full) {
				unitList.add(unitReq);
				response = new Response(true, "Add unit request succeeded");
			} else {
				response = new Response(false, "Add unit failed, venue full");
			}
		} else {
			response = new Response(false, "Add unit failed, venue not found");
		}
		return response;

	}

	public Response modifyUnit(Unit unitReq) {
		Response response = null;
		for (Unit unit : unitList) {
			if (unit.getUnitID() == unitReq.getUnitID()) {
				unitList.set(unitList.indexOf(unit), unitReq);
				response = new Response(true, "Unit modified successfully");
			} else {
				response = new Response(false, "Unit not found");
			}
		}

		return response;
	}

	public Response removeUnit(String unitID) {
		Response response = null;
		for (Unit unit : unitList) {
			if (unit.getUnitID() == unitID) {
				unitList.remove(unit);
				return response = new Response(true, "Unit removed successfully");
			} else {
				return response = new Response(false, "Unit not found");
			}
		}
		return response;
	}

	public int size() {
		return unitList.size();
	}
	
	public String getFirstAvailable(){
		for(Unit unit: unitList){
			if (unit.isBooked()==false){
				return unit.getUnitID();
			}
		}
		return "No vacancy";
	}
	
	public Unit getUnitByID(String unitIDReq){
		for(Unit unit: unitList){
			if(unit.getUnitID()==unitIDReq){
				return unit;
			}
		}
		return null;
	}
	
	@Override
	public String toString(){
		String output="";
		for(Unit unit: unitList){
			output+=unit.toString();
		}
		return output;
	}
}
