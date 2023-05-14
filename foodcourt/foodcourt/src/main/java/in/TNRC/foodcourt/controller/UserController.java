package in.TNRC.foodcourt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.TNRC.foodcourt.dto.ResponseDto;
import in.TNRC.foodcourt.dto.user.SignInDto;
import in.TNRC.foodcourt.dto.user.SignInReponseDto;
import in.TNRC.foodcourt.dto.user.SignupDto;
import in.TNRC.foodcourt.service.UserService;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("user")
public class UserController {
	
	  @Autowired
	    UserService userService;

	    // two apis

	    // signup

	    @PostMapping("/signup")
	    public ResponseDto signup(@RequestBody SignupDto signupDto) {
	        return userService.signUp(signupDto);
	    }

//
//	    // signin
//
	    @PostMapping("/signin")
	    public SignInReponseDto signIn(@RequestBody SignInDto signInDto) {
	        return userService.signIn(signInDto);
	    }



}
