package com.ghip.aaa.endpoint;

import com.ghip.aaa.domain.ApplicationUser;
import com.ghip.aaa.repository.ApplicationUserRepository;
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
	public void adduser(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
	}

	@GetMapping
	public List<ApplicationUser> getUsers() {
		return userRepository.findAll();
	}

	@PutMapping("/{username}")
	public void editUser(@PathVariable String username, @RequestBody ApplicationUser user) {
        ApplicationUser existingUser = userRepository.findOne(username);
		Assert.notNull(existingUser , "User not found");
        existingUser.setComment(user.getComment());
        userRepository.save(existingUser);
	}

	@DeleteMapping("/{username}")
	public void deleteUser(@PathVariable String username) {
        userRepository.delete(username);
	}
}