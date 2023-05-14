package in.TNRC.foodcourt.service;

import java.util.List;



import in.TNRC.foodcourt.dto.ProductDto;
import in.TNRC.foodcourt.exception.ProductNotExistsException;
import in.TNRC.foodcourt.model.Product;
import in.TNRC.foodcourt.model.Shop;


public interface ProductService {
	
	public List<ProductDto> getAllProducts();
	
	public ProductDto getProductDto(Product product);
	
	public void updateProduct(ProductDto productDto, Integer productId) throws Exception;
	
	public String deleteProduct(Integer id);

    public void saveProduct(ProductDto productdto,Shop shop);
    
    public Product findById(Integer productId) throws ProductNotExistsException ;
    
    public List<Product> getProductsByShopId(Integer shopId);
    


}
