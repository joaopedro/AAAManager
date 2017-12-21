package com.ghip.aaa.endpoint;

import com.ghip.aaa.domain.ApplicationUser;
import com.ghip.aaa.repository.ApplicationUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {

	private ApplicationUserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public ApplicationUserController(ApplicationUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping
	public void adduser(@RequestBody ApplicationUser applicationUser) {
        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        userRepository.save(applicationUser);
	}

	@GetMapping
	public List<ApplicationUser> getUsers() {
		return userRepository.findAll();
	}

	@PutMapping("/{username}")
	public void editUser(@PathVariable String username, @RequestBody ApplicationUser applicationUser) {
        ApplicationUser existingApplicationUser = userRepository.findOne(username);
		Assert.notNull(existingApplicationUser, "ApplicationUser not found");
        existingApplicationUser.setComment(applicationUser.getComment());
        userRepository.save(existingApplicationUser);
	}

	@DeleteMapping("/{username}")
	public void deleteUser(@PathVariable String username) {
        userRepository.delete(username);
	}

}