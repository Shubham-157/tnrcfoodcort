package in.TNRC.foodcourt.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.TNRC.foodcourt.model.Shop;

@Repository
public interface ShopsRepository extends JpaRepository<Shop, Integer> {

	
	
}
