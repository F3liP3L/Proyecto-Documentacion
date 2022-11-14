package edu.uco.quickjob.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.domain.IdentificationTypeDTO;
import edu.uco.quickjob.domain.UserDTO;
import edu.uco.quickjob.service.bussines.user.FindUserUseCase;
import edu.uco.quickjob.service.bussines.user.implementation.FindUserUseCaseImpl;
import edu.uco.quickjob.service.command.CreateUserCommand;
import edu.uco.quickjob.service.command.FindCityCommand;
import edu.uco.quickjob.service.command.FindIdentificationTypeCommand;
import edu.uco.quickjob.service.command.implementation.CreateUserCommandImpl;
import edu.uco.quickjob.service.command.implementation.FindCityCommandImpl;
import edu.uco.quickjob.service.command.implementation.FindIdentificationCommandImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private CreateUserCommand createUserCommand = new CreateUserCommandImpl();
	private FindCityCommand findCityCommand = new FindCityCommandImpl();
	private FindIdentificationTypeCommand findIdentificationType = new FindIdentificationCommandImpl();
	
	@GetMapping("/identificationType")
	public ResponseEntity<List<IdentificationTypeDTO>> findIdentificationType() {
		return new ResponseEntity<>(findIdentificationType.findIndetification(),HttpStatus.OK);
	}
	
	@GetMapping("/city")
	public ResponseEntity<List<CityDTO>> findCiType() {
		return new ResponseEntity<>(findCityCommand.findCity(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
		
		createUserCommand.createUser(user);
		
		// try and catch
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}
