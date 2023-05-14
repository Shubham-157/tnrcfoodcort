package in.TNRC.foodcourt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import in.TNRC.foodcourt.model.Shop;
import jakarta.validation.constraints.NotNull;

@JsonInclude(value = Include.NON_EMPTY)
public class ProductDto {
	
	private int id;
	private @NotNull String name;
	private @NotNull String imageURL;
	private @NotNull double price;
	private @NotNull Integer shopId;
	private Shop shops;

	public Shop getShops() {
		return shops;
	}
	public void setShops(Shop shops) {
		this.shops = shops;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	

}
