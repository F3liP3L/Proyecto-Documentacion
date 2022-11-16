package edu.uco.quickjob.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.quickjob.controller.response.Response;
import edu.uco.quickjob.controller.validator.Validator;
import edu.uco.quickjob.controller.validator.user.CreateServiceValidator;
import edu.uco.quickjob.crosscutting.exception.QuickjobCustomException;
import edu.uco.quickjob.crosscutting.messages.Messages;
import edu.uco.quickjob.crosscutting.messages.enumeration.Message;
import edu.uco.quickjob.domain.ServiceDTO;
import edu.uco.quickjob.domain.ServiceTypeDTO;
import edu.uco.quickjob.domain.SubserviceTypeDTO;
import edu.uco.quickjob.service.command.CreateServiceCommand;
import edu.uco.quickjob.service.command.FindServiceTypeCommand;
import edu.uco.quickjob.service.command.FindSubserviceTypeCommand;
import edu.uco.quickjob.service.command.implementation.CreateServiceCommandImpl;
import edu.uco.quickjob.service.command.implementation.FindServiceTypeCommandImpl;
import edu.uco.quickjob.service.command.implementation.FindSubserviceTypeCommandImpl;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

	private FindServiceTypeCommand findServiceTypeCommand = new FindServiceTypeCommandImpl();
	private FindSubserviceTypeCommand findSubserviceTypeCommand = new FindSubserviceTypeCommandImpl();

	private CreateServiceCommand createServiceCommand = new CreateServiceCommandImpl();
	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/serviceType")
	public ResponseEntity<List<ServiceTypeDTO>> findServiceType() {
		return new ResponseEntity<>(findServiceTypeCommand.findServiceType(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/subServiceType/{serviceType}")
	public ResponseEntity<List<SubserviceTypeDTO>> findSubserviceType(@PathVariable("serviceType") String serviceType) {
		return new ResponseEntity<>(findSubserviceTypeCommand.findSubserviceType(serviceType), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public ResponseEntity<Response<ServiceDTO>> createUser(@RequestBody ServiceDTO service) {

		final Response<ServiceDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			Validator<ServiceDTO> validator = new CreateServiceValidator();
			List<Message> messages = validator.validate(service);
			
			//if(!messages.isEmpty()) {
				createServiceCommand.execute(service);
				List<ServiceDTO> data = new ArrayList<>();
				data.add(service);
				response.setData(data);
				response.addSuccessMessage(Messages.ResponseServiceController.SERVICE_CREATED_SUCCESSFULLY);
			//} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response.setMessages(messages);
			// }
			
		} catch (final QuickjobCustomException exception) {
			httpStatus = HttpStatus.BAD_REQUEST;

			if (exception.isTechnicalException()) {
				response.addErrorMessage(Messages.ResponseServiceController.SERVICE_CREATED_ERROR);
			} else {
				response.addErrorMessage(exception.getMessage());
			}
			exception.printStackTrace();

		} catch (final Exception exception) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.addFatalMessage(Messages.ResponseServiceController.SERVICE_CREATED_UNEXPECTED_ERROR);

			exception.printStackTrace();
		}
		return new ResponseEntity<>(response, httpStatus);
	}

}
