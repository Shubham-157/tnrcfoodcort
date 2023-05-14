package in.TNRC.foodcourt.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.TNRC.foodcourt.model.Contact;
import in.TNRC.foodcourt.service.ContactService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping
public class ContactController {
	private  ContactService cService;

    public ContactController(ContactService contactService) {
        this.cService = contactService;
    }

    @PostMapping("/contact")
    public ResponseEntity<String> sendContactMessage(@Valid @RequestBody Contact contact) {
        try {
            cService.saveContact(contact);
            return ResponseEntity.ok("Thank you for contacting us!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save contact: " + e.getMessage());
        }
    }
}
