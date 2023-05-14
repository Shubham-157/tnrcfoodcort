package in.TNRC.foodcourt.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.TNRC.foodcourt.Repository.ProductRepository;
import in.TNRC.foodcourt.dto.ProductDto;
import in.TNRC.foodcourt.exception.ProductNotExistsException;
import in.TNRC.foodcourt.model.Product;
import in.TNRC.foodcourt.model.Shop;

@Service
@Transactional
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ShopsService shopsService;

	@Override
    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setImageURL(product.getImageURL());
        productDto.setName(product.getName());
        productDto.setShopId(product.getShop().getId());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }
	@Override
	public List<ProductDto> getAllProducts() {
		 List<Product> allProducts = productRepository.findAll();

	        List<ProductDto> productDtos = new ArrayList<>();
	        for(Product product: allProducts) {
	            productDtos.add(getProductDto(product));
	        }
	        return productDtos;
	}


	@Override
	 public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        // throw an exception if product does not exists
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not present");
        }
        Product product = optionalProduct.get();
       
        product.setImageURL(productDto.getImageURL());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

	@Override
	public String deleteProduct(Integer id) {
		Product product = productRepository.findById(id).get();
		if (product != null) {
			productRepository.delete(product);
			return "Employee Delete Sucessfully"+id;
			}
			return "Something wrong on server";
			}
	

	@Override
	public void saveProduct(ProductDto productDto,Shop shop) {
		 Product product = new Product();
	       
	        product.setImageURL(productDto.getImageURL());
	        product.setName(productDto.getName());
	        product.setShop(shop);
	        product.setPrice(productDto.getPrice());
	        productRepository.save(product);


}
	@Override
	public Product findById(Integer productId) throws ProductNotExistsException {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		 if (optionalProduct.isEmpty()) {
	            throw new ProductNotExistsException("product id is invalid: " + productId);
	        }
		 return optionalProduct.get();
    }
	@Override
	public List<Product> getProductsByShopId(Integer shopId) {
		 return productRepository.findByShopId(shopId);
	}
	
	
	}
	


	
	
