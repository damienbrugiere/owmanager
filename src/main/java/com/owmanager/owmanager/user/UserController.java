package com.owmanager.owmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.owmanager.owmanager.blizzard.BlizzardService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BlizzardService blizzardService;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/connect/{code}")
	public User createUser(@PathVariable("code") String code) {
		User user = this.blizzardService.connectUserWithBlizzardLogin(code);
		User userFind = userService.findOne(user.getBattletag());
		if(userFind!= null) {
			return userFind;
		}
		return userService.create(user);
	}
}
