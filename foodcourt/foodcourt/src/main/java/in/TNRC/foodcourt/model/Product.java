package in.TNRC.foodcourt.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column(name = "product_name")
    private @NotNull String name;
	
	@Column(name = "imageURL")
    private @NotNull String imageURL;
	
	

	@Column(name = "price")
    private @NotNull double price;
	
	@CreationTimestamp
	@Column(name="created_at", nullable = false, updatable =false)    
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
//	@Column(name = "shopId")
//	private @NotNull Integer shopId;
    
 // Many to one relationship
    @ManyToOne
    @JoinColumn(name = "shop_id")
     Shop shop;

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


	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	
	

	public Product(int id, @NotNull String name, @NotNull String imageURL, @NotNull double price, Date createdAt,
			Date updatedAt, Shop shop) {
		super();
		this.id = id;
		this.name = name;
		this.imageURL = imageURL;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.shop = shop;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
	
}
