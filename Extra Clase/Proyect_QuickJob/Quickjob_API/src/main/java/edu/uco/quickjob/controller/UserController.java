package edu.uco.quickjob.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.quickjob.controller.response.Response;
import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.domain.CityDTO;
import edu.uco.quickjob.domain.IdentificationTypeDTO;
import edu.uco.quickjob.domain.UserDTO;
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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/identificationType")
	public ResponseEntity<List<IdentificationTypeDTO>> findIdentificationType() {
		return new ResponseEntity<>(findIdentificationType.findIndetification(),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/city")
	public ResponseEntity<List<CityDTO>> findCiType() {
		return new ResponseEntity<>(findCityCommand.findCity(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Response<UserDTO>> createUser(@RequestBody UserDTO user){
		
		final Response<UserDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;
		
		try {
			createUserCommand.createUser(user);	
			List<UserDTO> data = new ArrayList<>();
			data.add(user);
			response.setData(data);
			response.addSuccessMessage("The user has been created succesfully");
		} catch (final QuickjobCustomException exception) {
			httpStatus = HttpStatus.BAD_REQUEST;
			
			if(exception.isTechnicalException()) {
				response.addErrorMessage("There was an error trying created the user");
			} else {
				response.addErrorMessage(exception.getMessage());
			}
		} catch (final Exception exception) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.addFatalMessage("There was a unexpected problem trying to created the user.");
		}
		return new ResponseEntity<>(response, httpStatus);
	}

}
