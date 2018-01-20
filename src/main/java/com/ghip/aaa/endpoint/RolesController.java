package com.ghip.aaa.endpoint;

import com.ghip.aaa.domain.Authority;
import com.ghip.aaa.exceptions.ObjectFoundException;
import com.ghip.aaa.repository.AuthorityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

	private AuthorityRepository authorityRepository;

	public RolesController(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}

	@PostMapping
	public void addRole(@RequestBody Authority authority) {
        authorityRepository.save(authority);
	}

	@GetMapping
	public List<Authority> getRoles() {
		return authorityRepository.findByEnabled(true);
	}

	public void editRole(@PathVariable long id, @RequestBody String name) {
        Authority authority = authorityRepository.findOne(id);
		if(authority == null)
			throw new ObjectFoundException("Role "+ id + " not found");
        authority.setName(name);
        authorityRepository.save(authority);
	}

	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable long id) {
		Authority authority = authorityRepository.findOne(id);
		if(authority == null)
		    throw new ObjectFoundException("Role "+ id + " not found");
		authority.setEnabled(false);
		authorityRepository.save(authority);
	}

}