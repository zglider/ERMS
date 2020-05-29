package serverPack;

import java.util.ArrayList;

public class UnitList {
	private ArrayList<Unit> unitList;
	public UnitList(){
		unitList = new ArrayList<Unit>();
	}
	
	public Response addUnit(Unit unitReq){
		Response response = null;
		for (Venue venue: Server.venueList.getList()){
			if (venue.getID()==unitReq.getVenueID()){
				if (venue.getUnits().size()<venue.getCapacity()){
					unitList.add(unitReq);
					return response = new Response(true, "Add unit request succeeded");
				}
				else{
					return response = new Response(false, "Venue is full");
				}
			}
			else{
				return response = new Response(false, "Venue not found");
			}
		}
		return response;
		
	}
	
	public Response modifyUnit(Unit unitReq){
		Response response = null;
		for (Unit unit: unitList){
			if (unit.getUnitID()==unitReq.getUnitID()){
				unitList.set(unitList.indexOf(unit), unitReq);
				return response = new Response(true, "Unit modified successfully");
			}
			else{
				return response = new Response(false, "Unit not found");
			}
		}
		
		
		return response;
	}
	
	public Response removeUnit(String unitID){
		Response response = null;
		for (Unit unit: unitList){
			if (unit.getUnitID()==unitID){
				unitList.remove(unit);
				return response = new Response(true, "Unit removed successfully");
			}
			else{
				return response = new Response(false, "Unit not found");
			}
		}
		return response;
	}

	public int size() {	
		return unitList.size();
	}



}
