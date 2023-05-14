package in.TNRC.foodcourt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.TNRC.foodcourt.model.Cart;
import in.TNRC.foodcourt.model.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	 List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
