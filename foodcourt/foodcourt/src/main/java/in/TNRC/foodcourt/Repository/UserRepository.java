package in.TNRC.foodcourt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.TNRC.foodcourt.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
}
