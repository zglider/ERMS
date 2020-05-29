package serverPack;

import java.util.ArrayList;

public class VenueList {
	ArrayList<Venue> venueList;
	
	public VenueList(){
		venueList = new ArrayList<Venue>();
	}
	
	public Response addVenue(Venue venueReq){
		Response response = null;
		boolean found = venueList.contains(venueReq);
		
		if (found){
			response = new Response(false, "Cannot add venue, already exists");
		}
		else{
			venueList.add(venueReq);
			response = new Response(true,"Venue added successfully");
		}
		
		return response;
	}
	
	public ArrayList<Venue> getList(){
		return this.venueList;
	}
	
	public void setList(ArrayList<Venue> venueList){
		this.venueList=venueList;
	}
}
