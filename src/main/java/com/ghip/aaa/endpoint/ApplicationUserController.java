package com.ghip.aaa.endpoint;

import com.ghip.aaa.domain.ApplicationUser;
import com.ghip.aaa.exceptions.UserNotFoundException;
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

	public ApplicationUserController(ApplicationUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping
	public void adduser(@RequestBody ApplicationUser applicationUser) {
        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        userRepository.save(applicationUser);
	}

	@GetMapping
	public List<ApplicationUser> getUsers() {
		return userRepository.findByEnabled(true);
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
		ApplicationUser user = userRepository.findOne(username);
		if(user == null)
		    throw new UserNotFoundException("user "+ username + " not found");
		user.setEnabled(false);
		userRepository.save(user);
	}

}