package serverPack;

import java.io.Serializable;

//this class is the data structure for sending 
//and receiving requests between the client and the server
public class Request implements Serializable{
	
	private static final long serialVersionUID = 4476856958562649493L;
	private int operation;
	private String listItemType;
	private Object listItem;
	

	public Request(int operation, String listItemType, Object listItem) {
		this.operation = operation;
		this.listItemType = listItemType;
		this.listItem = listItem;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}


	public String getListItemType() {
		return listItemType;
	}

	public void setListItemType(String listItemType) {
		this.listItemType = listItemType;
	}

	public Object getListItem() {
		return listItem;
	}

	public void setListItem(Object listItem) {
		this.listItem = listItem;
	}

	

	@Override
	public String toString() {
		return "Request [Operation=" + operation + ", ListItemType=" + listItemType + ", ListItem=" + listItem.toString()+ "]";
	}
	
	
}
