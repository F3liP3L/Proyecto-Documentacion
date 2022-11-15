package edu.uco.quickjob.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.quickjob.domain.ServiceTypeDTO;
import edu.uco.quickjob.domain.SubserviceTypeDTO;
import edu.uco.quickjob.service.command.FindServiceTypeCommand;
import edu.uco.quickjob.service.command.FindSubserviceTypeCommand;
import edu.uco.quickjob.service.command.implementation.FindServiceTypeCommandImpl;
import edu.uco.quickjob.service.command.implementation.FindSubserviceTypeCommandImpl;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
	
	
	private FindServiceTypeCommand findServiceTypeCommand = new FindServiceTypeCommandImpl();
	private FindSubserviceTypeCommand findSubserviceTypeCommand = new FindSubserviceTypeCommandImpl();
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/serviceType")
	public ResponseEntity<List<ServiceTypeDTO>> findServiceType() {
		return new ResponseEntity<>(findServiceTypeCommand.findServiceType(),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/subServiceType")
	public ResponseEntity<List<SubserviceTypeDTO>> findSubserviceType() {
		return new ResponseEntity<>(findSubserviceTypeCommand.findSubserviceType(),HttpStatus.OK);
	}
	
	
	

}
