package in.TNRC.foodcourt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.TNRC.foodcourt.Repository.CartRepository;
import in.TNRC.foodcourt.dto.cart.AddToCartDto;
import in.TNRC.foodcourt.dto.cart.CartDto;
import in.TNRC.foodcourt.dto.cart.CartItemDto;
import in.TNRC.foodcourt.exception.CustomException;
import in.TNRC.foodcourt.model.Cart;
import in.TNRC.foodcourt.model.Product;
import in.TNRC.foodcourt.model.User;

@Service
public class CartServiceimpl implements CartService {

	 @Autowired
	 ProductService productService;

	  @Autowired
	  CartRepository cartRepository;
	@Override
	public void addToCart(AddToCartDto addToCartDto, User user) {
		// validate if the product id is valid
        Product product = productService.findById(addToCartDto.getProductId());
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());
        
     // save the cart
        cartRepository.save(cart);

	}

	@Override
	public CartDto listCartItems(User user) {
		List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

        List<CartItemDto> cartItems = new ArrayList<>();
        double totalCost = 0;
        for (Cart cart: cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }

        CartDto cartDto = new CartDto();
        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems(cartItems);
        return  cartDto;   
	}

	@Override
	public void deleteCartItem(Integer cartItemId, User user) {
		 // the item id belongs to user

        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);

        if (optionalCart.isEmpty()) {
            throw new CustomException("cart item id is invalid: " + cartItemId);
        }

        Cart cart = optionalCart.get();

        if (cart.getUser() != user) {
            throw  new CustomException("cart item does not belong to user: " +cartItemId);
        }

        cartRepository.delete(cart);

	}

	

}
