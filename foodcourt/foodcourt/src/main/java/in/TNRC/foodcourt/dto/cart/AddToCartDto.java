package in.TNRC.foodcourt.dto.cart;

import in.TNRC.foodcourt.model.Product;
import in.TNRC.foodcourt.model.User;
import jakarta.validation.constraints.NotNull;

public class AddToCartDto {
	
	private Integer id;
    private @NotNull Integer productId;
    private @NotNull Integer quantity;
    private Product products;
    private User user;
	public AddToCartDto() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
    
    

}
