package serverPack;

import java.io.Serializable;

//this is the class to send and receive 
//responses for requests between the clients and the server
public class Response implements Serializable {
	
	private static final long serialVersionUID = 779406261798638003L;
	private boolean success;
	private String message;
	
	public Response(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [Success=" + success + ", Message=" + message + "]";
	}
	
	
	
}
