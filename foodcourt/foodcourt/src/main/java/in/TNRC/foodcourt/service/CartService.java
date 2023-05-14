package in.TNRC.foodcourt.service;

import in.TNRC.foodcourt.dto.cart.AddToCartDto;
import in.TNRC.foodcourt.dto.cart.CartDto;
import in.TNRC.foodcourt.dto.cart.CartItemDto;
import in.TNRC.foodcourt.model.User;

public interface CartService {

	public void addToCart(AddToCartDto addToCartDto, User user);
	
	public CartDto listCartItems(User user);
	
	 public void deleteCartItem(Integer cartItemId, User user);
	 
	
}
