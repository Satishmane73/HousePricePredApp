package customeException;

public class StateNotFoundException extends RuntimeException {
	private String msg;

	public StateNotFoundException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
