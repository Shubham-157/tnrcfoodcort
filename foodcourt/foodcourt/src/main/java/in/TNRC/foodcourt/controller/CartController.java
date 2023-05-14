package in.TNRC.foodcourt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.TNRC.foodcourt.Repository.CartRepository;
import in.TNRC.foodcourt.common.ApiResponse;
import in.TNRC.foodcourt.dto.ProductDto;
import in.TNRC.foodcourt.dto.cart.AddToCartDto;
import in.TNRC.foodcourt.dto.cart.CartDto;
import in.TNRC.foodcourt.model.Shop;
import in.TNRC.foodcourt.model.User;
import in.TNRC.foodcourt.service.AuthenticationService;
import in.TNRC.foodcourt.service.CartService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/cart")
public class CartController {

	 @Autowired
	 private CartService cartService;

	 @Autowired
	 private AuthenticationService authenticationService;
	 
	
	 
	 // post cart api
	    @PostMapping("/add")
	    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
	                                                 @RequestParam("token") String token) {
	    	System.out.println("token is: "+token);
	        // authenticate the token
	        authenticationService.authenticate(token);

	        

	        // find the user

	        User user = authenticationService.getUser(token);


	        cartService.addToCart(addToCartDto, user );

	        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
	    }


	    // get all cart items for a user
	    @GetMapping("/getallcartitems")
	    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {
	        // authenticate the token
	        authenticationService.authenticate(token);

	        // find the user
	        User user = authenticationService.getUser(token);

	        // get cart items

	        CartDto cartDto = cartService.listCartItems(user);
	        return new ResponseEntity<>(cartDto, HttpStatus.OK);
	    }

	    // delete a cart item for a user

	    @DeleteMapping("/delete/{cartItemId}")
	    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId,
	                                                      @RequestParam("token") String token) {

	        // authenticate the token
	        authenticationService.authenticate(token);

	        // find the user
	        User user = authenticationService.getUser(token);

	        cartService.deleteCartItem(itemId, user);

	        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);

	    }
	    
//	    @PostMapping("/update/{productId}")
//	    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) throws Exception {
//	        Optional<Shop> optionalCategory = shopsRepository.findById(productDto.getShops().getId());
//	        if (!optionalCategory.isPresent()) {
//	            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.BAD_REQUEST);
//	        }
//	        productService.updateProduct(productDto, productId);
//	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been updated"), HttpStatus.OK);
//	    }
	    
//	    @PostMapping("/update/{cartitemId}")
//	    public ResponseEntity<ApiResponse> updateCartItem(@PathVariable("cartItemId") Integer itemId,@RequestParam("token") String token) {
//	    	
//	    	  // authenticate the token
//	        authenticationService.authenticate(token);
//
//	        // find the user
//	        User user = authenticationService.getUser(token);
//	        
//	        cartService.updateCartItem(itemId, user);
//	        
//	        return new ResponseEntity<>(new ApiResponse(true, "Quantity has been removed"), HttpStatus.OK);
//
//	    }

	
}
