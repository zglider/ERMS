package serverPack;

import java.util.ArrayList;


//this the table class for the venue data structure
public class VenueList extends ItemList{
	ArrayList<Venue> venueList;

	public VenueList() {
		venueList = new ArrayList<Venue>();
	}
	
	public Response addItem(Venue venueReq) {
		
		if (venueList.contains(venueReq)) {
			return new Response(false, "Cannot add venue, already exists");
		} else {
			venueList.add(venueReq);
			return new Response(true, "Venue added successfully");
		}
	}
	
	public Response modifyItem(Venue venueReq) {
		for (Venue venue : Server.venueList.getList()) {
			if (venue.getVenueID() == venueReq.getVenueID()) {
				venueList.set(venueList.indexOf(venue), venueReq);
				new Response(true, "Found and modified the venue");
			}
		}
		return new Response(false, "Cannot modify, venue not found");
	}
	
	public Response removeItem(String reqVenueID) {
		for (Venue venue : Server.venueList.getList()) {
			if (venue.getVenueID() == reqVenueID) {
				for (Unit unit : venue.getUnits().getUnitList()) {
					if (unit.isBooked()) {
						return new Response(false, "Cannot delete venue, one of its units is booked");
					}
				}
				venueList.remove(venue);
				return new Response(true, "Found and deleted the venue");
			}
		}
		return new Response(false, "Cannot delete, venue not found");
	}

	public ArrayList<Venue> getList() {
		return this.venueList;
	}

	public void setList(ArrayList<Venue> venueList) {
		this.venueList = venueList;
	}

	public Venue getVenueByID(String venueIDReq) {
		for (Venue venue : venueList) {
			if (venue.getVenueID() == venueIDReq) {
				return venue;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String output = "";
		for (Venue ven : venueList) {
			output += ven.toString() + "\n";
		}
		return output;
	}
	
	public Response processRequest(Request req){
		switch (req.getOperation()) {
		case (0):
			return addItem((Venue)req.getListItem());
		case (1):
			return modifyItem((Venue)req.getListItem());
		case (2):
			return removeItem(((Venue) (req.getListItem())).getVenueID());
		default:
			break;
		}
		return null;
	}
}
