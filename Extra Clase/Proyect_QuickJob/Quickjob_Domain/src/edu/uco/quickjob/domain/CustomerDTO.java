package edu.uco.quickjob.domain;


public class CustomerDTO {
	
	private UserDTO user;
	private ServiceDTO usedService;
	
	public CustomerDTO() {
		super();
	}
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}

	public ServiceDTO getUsedService() {
		return usedService;
	}

	public void setUsedService(ServiceDTO usedService) {
		this.usedService = usedService;
	}
	
	
	
	
	

}
