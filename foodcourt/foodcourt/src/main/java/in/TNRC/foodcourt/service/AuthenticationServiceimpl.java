package in.TNRC.foodcourt.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.TNRC.foodcourt.Repository.TokenRepository;
import in.TNRC.foodcourt.exception.AuthenticationFailException;
import in.TNRC.foodcourt.model.AuthenticationToken;
import in.TNRC.foodcourt.model.User;

@Service
public class AuthenticationServiceimpl implements AuthenticationService {

	 @Autowired
	 TokenRepository tokenRepository;
	 @Transactional
	 @Override
	 public void saveConfirmationToken(AuthenticationToken authenticationToken) {
		 tokenRepository.save(authenticationToken);
	}

	@Override
	public AuthenticationToken getToken(User user) {
		return tokenRepository.findByUser(user);
	}

	@Override
	public User getUser(String token) {
		 final AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
	        if(Objects.isNull(authenticationToken)) {
	            return null;
	        }
	        // authenticationToken is not null
	        return authenticationToken.getUser();
	}

	@Override
	public void authenticate(String token) throws AuthenticationFailException {
		System.out.println("token is: "+token);
		 // null check
        if(Objects.isNull(token)) {
            // throw an exception
            throw new AuthenticationFailException("token not present");
            
        }
        if(Objects.isNull(getUser(token))) {
            throw new AuthenticationFailException("token not valid");
        }
		
	}

	

}
