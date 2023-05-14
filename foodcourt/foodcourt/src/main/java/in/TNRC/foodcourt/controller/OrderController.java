package in.TNRC.foodcourt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import in.TNRC.foodcourt.dto.checkout.CheckoutItemDto;
import in.TNRC.foodcourt.dto.checkout.StripeResponse;
import in.TNRC.foodcourt.service.AuthenticationService;
import in.TNRC.foodcourt.service.OrderService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/order")
public class OrderController {
	
	 @Autowired
	    private AuthenticationService authenticationService;

	    @Autowired
	    private OrderService orderService;
	    
	    @PostMapping("/create-checkout-session")
	    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList)
	            throws StripeException {
	        Session session = orderService.createSession(checkoutItemDtoList);
	        StripeResponse stripeResponse = new StripeResponse(session.getId());
	        return new ResponseEntity<>(stripeResponse, HttpStatus.OK);

	    }


}
