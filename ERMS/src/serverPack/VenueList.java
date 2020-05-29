package serverPack;

import java.util.ArrayList;

public class VenueList {
	ArrayList<Venue> venueList;
	
	public VenueList(){
		venueList = new ArrayList<Venue>();
	}
	
	public ArrayList<Venue> getList(){
		return this.venueList;
	}
	
	public void setList(ArrayList<Venue> venueList){
		this.venueList=venueList;
	}
}
