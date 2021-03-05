package react.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ContactLoader implements CommandLineRunner {
	private final ContactRepository repo;
	
	@Autowired
	public ContactLoader(ContactRepository repo) {
		this.repo = repo;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repo.save(new Contact("joe", "klapper", "jk@jk.com"));
	}
}
