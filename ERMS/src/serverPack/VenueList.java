package serverPack;

import java.util.ArrayList;

public class VenueList {
	ArrayList<Venue> venueList;

	public VenueList() {
		venueList = new ArrayList<Venue>();
	}

	public Response addVenue(Venue venueReq) {
		Response response = null;
		boolean found = venueList.contains(venueReq);

		if (found) {
			response = new Response(false, "Cannot add venue, already exists");
		} else {
			venueList.add(venueReq);
			response = new Response(true, "Venue added successfully");
		}

		return response;
	}

	public Response modifyVenue(Venue venueReq) {
		Response response = null;
		boolean found = false;
		for (Venue venue : Server.venueList.getList()) {
			if (venue.getID() == venueReq.getID()) {
				found = true;
				venueList.set(venueList.indexOf(venue), venueReq);
			}
		}

		if (found) {

			response = new Response(true, "Found and modified the venue");
		} else {

			response = new Response(false, "Cannot modify, venue not found");
		}

		return response;
	}
	
	public Response removeVenue(String venueID){
		Response response = null;
		boolean found = false;
		for (Venue venue: Server.venueList.getList()){
			if (venue.getID()==venueID){
				venueList.remove(venue);
				found=true;
			}
		}
		if (found){
			response = new Response(true, "Found and deleted the venue");
		}
		else{
			response = new Response(false, "Cannot delete, venue not found");
		}
		
		return response;
	}

	public ArrayList<Venue> getList() {
		return this.venueList;
	}

	public void setList(ArrayList<Venue> venueList) {
		this.venueList = venueList;
	}
	
	public Venue getVenueByID(String venueIDReq){
		for(Venue venue: venueList){
			if(venue.getID()==venueIDReq){
				return venue;
			}
		}
		return null;
	}
}
