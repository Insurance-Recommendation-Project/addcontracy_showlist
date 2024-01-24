package org.lsi.controller;


import org.lsi.entities.Contract;
import org.lsi.entities.ERole;
import org.lsi.entities.Role;
import org.lsi.repositories.TokenRepository;
import org.lsi.repositories.UserRepository;
import org.lsi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/contrats")
public class TestController {

	@Autowired
	private TestService testServ;

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/addContract")
	public ResponseEntity<?> addContract(@RequestHeader("Authorization") String token, @RequestBody Contract contract) {
		// Your authentication logic here (check user roles, etc.)
		// For simplicity, I'm assuming any authenticated user can add a contract.
		// Modify this based on your authentication requirements.

		// Example: Get the user roles
		//List<Role> roles = tokenRepository.findByToken(token).orElseThrow().getUser().getRoles();

		// Example: Check if the user has the required role (ROLE_ADMIN)
		//boolean isAdmin = roles.stream().anyMatch(role -> role.getName() == ERole.ROLE_ADMIN);
		Set<Role> roless= tokenRepository.findByToken(token).orElseThrow().getUser().getRoles();
		boolean isAdmin = roless.stream().anyMatch(role -> role.getName() == ERole.ROLE_ADMIN);
	try{
		if (isAdmin) {
			Contract savedContract = testServ.addLand(contract.getBuyer(),
					contract.getSeller(),
					contract.getCost(),
					contract.getDesc(),
					contract.getProp(), // Assuming 'getProp' is a method in the Contract class
					contract.getDate());
			return new ResponseEntity<>(savedContract, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
		}
	} catch (Exception e) {
		// Handle the exception, log it, or take appropriate action
		e.printStackTrace(); // This is just an example, replace with proper logging
		return new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	@GetMapping("/listContracts")
	public ResponseEntity<List<Contract>> listContracts() {
		// Example: Get all contracts from the database
		List<Contract> contracts = testServ.getAll();
		return new ResponseEntity<>(contracts, HttpStatus.OK);
	}

	@GetMapping("/hello")
	public String test()
	{
		return "Hello world " ;
	}
}

