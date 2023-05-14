package in.TNRC.foodcourt.service;



import in.TNRC.foodcourt.dto.ResponseDto;
import in.TNRC.foodcourt.dto.user.SignInDto;
import in.TNRC.foodcourt.dto.user.SignInReponseDto;
import in.TNRC.foodcourt.dto.user.SignupDto;

public interface UserService {
	
	public ResponseDto signUp(SignupDto signupDto);
	
	
	public SignInReponseDto signIn(SignInDto signInDto);
	
	
	
}
