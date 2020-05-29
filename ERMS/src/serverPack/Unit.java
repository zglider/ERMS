package serverPack;

public class Unit {
	private int unitID;
	private String tier;
	private float price;
	
	public Unit(int unitID, String tier, float price){
		this.unitID = unitID;
		this.tier = tier;
		this.price = price;
	}

	public int getUnitID() {
		return unitID;
	}

	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Unit [UnitID=" + unitID + ", Tier=" + tier + ", Price=" + price + "]";
	}

}
