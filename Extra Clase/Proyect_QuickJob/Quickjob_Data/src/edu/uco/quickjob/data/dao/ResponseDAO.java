package edu.uco.quickjob.data.dao;

import java.util.List;

import edu.uco.quickjob.domain.ResponseDTO;

public interface ResponseDAO {
	
	void create (ResponseDTO response);
	
	List<ResponseDTO> find(ResponseDTO response);

}
