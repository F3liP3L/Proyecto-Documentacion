package edu.uco.quickjob.domain;

import java.util.List;

public class CustomerDTO {
	
	private UserDTO user;
	private List<ServiceDTO> usedService;
	
	public CustomerDTO() {
		super();
	}
	
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public List<ServiceDTO> getUsedService() {
		return usedService;
	}
	public void setUsedService(List<ServiceDTO> usedService) {
		this.usedService = usedService;
	}
	
	
	
	
	

}
