package edu.uco.quickjob.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.quickjob.domain.CommentDTO;

public interface CommentDAO {
	
void create (CommentDTO comment);
	
	List<CommentDTO> find(CommentDTO comment);
	
	void update (CommentDTO comment);
	
	void delete (UUID id);


}
