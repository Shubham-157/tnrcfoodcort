package in.TNRC.foodcourt.dto.checkout;

public class StripeResponse {

	 private String sessionId;

	public StripeResponse(String sessionId) {
		super();
		this.sessionId = sessionId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
