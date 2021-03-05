package react.spring.model;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {
	private ContactRepository repo;
	
	public ContactController(ContactRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping("/contacts")
	Collection<Contact> contacts(){
		System.out.println(repo.findAll().toString());
		return (Collection<Contact>) repo.findAll();
	}
	
	@PostMapping("/contacts")
	ResponseEntity<Contact> create(@RequestBody Contact contact){
		Contact result = repo.save(contact);
		return ResponseEntity.ok().body(result);
	}
}

