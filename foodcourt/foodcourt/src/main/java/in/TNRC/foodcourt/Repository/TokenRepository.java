package in.TNRC.foodcourt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.TNRC.foodcourt.model.AuthenticationToken;
import in.TNRC.foodcourt.model.User;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

	AuthenticationToken findByUser(User user);
	AuthenticationToken findByToken(String token);
}
