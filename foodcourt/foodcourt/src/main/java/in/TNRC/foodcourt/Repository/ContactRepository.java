package in.TNRC.foodcourt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.TNRC.foodcourt.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
