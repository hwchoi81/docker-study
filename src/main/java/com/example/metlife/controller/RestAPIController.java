package com.example.metlife.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.metlife.entity.User;
import com.example.metlife.repository.UserRepository;

@RestController
public class RestAPIController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String Hello() {
		return "Hello Test by WOOK";
	}
	
	@RequestMapping(value = "/user/{custId}",  method = RequestMethod.GET)
	public User select(@PathVariable(value="custId") String custId) {
		Optional<User> user = userRepository.findById(custId);
		
		return user.isPresent()?user.get():null;
		
	}

//	@RequestMapping(value = "save/user/{custId}/userName/{custName}",  method = RequestMethod.GET)
//	public void save(@PathVariable(value="custId") String custId
//						, @PathVariable(value="custId") String custName) {
//		//Optional<User> user = userRepository.findById(custId);
//		
//		User newUser = new User();
//		newUser.setUserId(custId);
//		newUser.setUserName(custName);	
//		
//		userRepository.save(newUser);
//	
//	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void create(@RequestBody() User user) {
		userRepository.save(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public void update(@RequestBody() User user) {
		if(userRepository.existsById(user.getUserId())) {
			userRepository.save(user);
		}
	}	
	
	@RequestMapping(value = "/user/{custId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value="custId") String custId) {
		if(userRepository.existsById(custId)) {
			userRepository.deleteById(custId);
		}
	}	
	
	@RequestMapping(value = "/user2/{userName}", method = RequestMethod.GET)
	public List<User> findByUserName(@PathVariable(value="userName") String userName) {
		List<User>  user = userRepository.findByUserName(userName);
		return user;
	}	
}
