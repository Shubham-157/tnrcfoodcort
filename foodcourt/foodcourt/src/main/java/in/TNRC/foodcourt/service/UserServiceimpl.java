package in.TNRC.foodcourt.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.TNRC.foodcourt.Repository.UserRepository;
import in.TNRC.foodcourt.dto.ResponseDto;
import in.TNRC.foodcourt.dto.user.SignInDto;
import in.TNRC.foodcourt.dto.user.SignInReponseDto;
import in.TNRC.foodcourt.dto.user.SignupDto;
import in.TNRC.foodcourt.exception.AuthenticationFailException;
import in.TNRC.foodcourt.exception.CustomException;
import in.TNRC.foodcourt.model.AuthenticationToken;
import in.TNRC.foodcourt.model.User;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Transactional
	@Override
	public ResponseDto signUp(SignupDto signupDto) {
 
    	        // check if user is already present
    	        if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
    	            // we have an user
    	            throw new CustomException("user already present");
    	        }


    	        // hash the password

    	        String encryptedpassword = signupDto.getPassword();

    	        try {
    	            encryptedpassword = hashPassword(signupDto.getPassword());
    	        } catch (NoSuchAlgorithmException e) {
    	            e.printStackTrace();
    	        }

    	        User user = new User(signupDto.getFirstName(), signupDto.getLastName(),
    	                signupDto.getEmail(), encryptedpassword);

    	        userRepository.save(user);

    	        // save the user

    	        // create the token
    	        
    	        final AuthenticationToken authenticationToken = new AuthenticationToken(user);

    	        authenticationService.saveConfirmationToken(authenticationToken);

    	        ResponseDto responseDto = new ResponseDto("success", "user created succesfully");
    	        return responseDto;
    	    }
    
		    private String hashPassword(String password) throws NoSuchAlgorithmException {
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        md.update(password.getBytes());
		        byte[] digest = md.digest();
		        String myHash = DatatypeConverter
		                .printHexBinary(digest).toUpperCase();
		        return myHash;
		    }
	

	@Override
	public SignInReponseDto signIn(SignInDto signInDto) {
		 // find user by email

        User user = userRepository.findByEmail(signInDto.getEmail());

        if (Objects.isNull(user)) {
            throw new AuthenticationFailException("user is not valid");
        }
     // hash the password

        try {
            if (!user.getPasswoprd().equals(hashPassword(signInDto.getPassword()))) {
                throw new AuthenticationFailException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // compare the password in DB

        // if password match

        AuthenticationToken token = authenticationService.getToken(user);
        

        // retrive the token

        if (Objects.isNull(token)) {
            throw new CustomException("token is not present");
        }

        return new SignInReponseDto("sucess", token.getToken());
       

        // return response

	}

}
