package in.TNRC.foodcourt.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_shops")
public class Shop
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Name Should Not be Null")
	@Column(name = "name")
	private String name;
	
	@Column(name = "imgurl")
	private String imgurl;
	
	@Column(name = "menu")
	private String menu;
	
//	@Column(name = "products")
//	private List<Product> products;
//	
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	@CreationTimestamp
	@Column(name="created_at", nullable = false, updatable =false)    
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;

	@OneToMany(cascade = CascadeType.ALL , mappedBy = "shop", fetch =FetchType.LAZY)
	List<Product> products;
	
	
	public List<Product> getProducts() {
		return products;
	}

	@JsonIgnore
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public int getId() {
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

	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Shop(int id, @NotBlank(message = "Name Should Not be Null") String name, String imgurl,
			List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.imgurl = imgurl;
		this.products = products;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", imgurl=" + imgurl + ", products=" + products + "]";
	}
	
	


	
	
	
}
