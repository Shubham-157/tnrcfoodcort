package in.TNRC.foodcourt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.TNRC.foodcourt.Repository.ContactRepository;

import in.TNRC.foodcourt.model.Contact;


@Service
@Transactional
public class ContactService {

	@Autowired
    ContactRepository cRepository;

	public Contact saveContact(Contact contact) {
		
		return cRepository.save(contact);
}
}
