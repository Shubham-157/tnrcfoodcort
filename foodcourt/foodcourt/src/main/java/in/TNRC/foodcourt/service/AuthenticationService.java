package in.TNRC.foodcourt.service;

import in.TNRC.foodcourt.exception.AuthenticationFailException;
import in.TNRC.foodcourt.model.AuthenticationToken;
import in.TNRC.foodcourt.model.User;

public interface AuthenticationService {

	public void saveConfirmationToken(AuthenticationToken authenticationToken);
	
	public AuthenticationToken getToken(User user);
	
	public User getUser(String token);
	
	public void authenticate(String token) throws AuthenticationFailException;
}
