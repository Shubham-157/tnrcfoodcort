package in.TNRC.foodcourt.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.TNRC.foodcourt.Repository.ShopsRepository;
import in.TNRC.foodcourt.common.ApiResponse;
import in.TNRC.foodcourt.dto.ProductDto;
import in.TNRC.foodcourt.model.Product;
import in.TNRC.foodcourt.model.Shop;
import in.TNRC.foodcourt.service.ProductService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
    
	@Autowired
	ShopsRepository shopsRepository;
	
	 @PostMapping("/add")
	 public ResponseEntity<ApiResponse> saveProduct(@RequestBody ProductDto productDto) {
	 Optional<Shop> optionalShop = shopsRepository.findById(productDto.getShops().getId());
	 if (!optionalShop.isPresent()) {
	     return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.BAD_REQUEST);
	   }
	 productService.saveProduct(productDto, optionalShop.get());
	 return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been added"), HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/shops/{shopId}/products")
	    public List<Product> getProductsByShopId(@PathVariable Integer shopId) {
	        return productService.getProductsByShopId(shopId);
	    }
	
	 
	 
	 @PostMapping("/update/{productId}")
	    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) throws Exception {
	        Optional<Shop> optionalCategory = shopsRepository.findById(productDto.getShops().getId());
	        if (!optionalCategory.isPresent()) {
	            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.BAD_REQUEST);
	        }
	        productService.updateProduct(productDto, productId);
	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been updated"), HttpStatus.OK);
	    }

	    @DeleteMapping("/deleteproduct/{id}")
	    public ResponseEntity<Void> deleteMenuById(@PathVariable Integer id) {
	        List<ProductDto> product = productService.getAllProducts();
	        if (product == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        productService.deleteProduct(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    @GetMapping("/products")
	    public ResponseEntity<List<ProductDto>> getProducts() {
	        List<ProductDto> products = productService.getAllProducts();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	

}
