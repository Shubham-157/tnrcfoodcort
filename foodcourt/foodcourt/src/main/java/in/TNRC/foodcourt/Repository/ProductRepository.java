package in.TNRC.foodcourt.Repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.TNRC.foodcourt.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	 @Query("SELECT p FROM Product p WHERE p.shop.id = :shopId")
	 List<Product> findByShopId(Integer shopId);

}

