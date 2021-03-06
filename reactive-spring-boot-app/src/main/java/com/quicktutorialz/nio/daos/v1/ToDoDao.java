package com.quicktutorialz.nio.daos.v1;

import com.quicktutorialz.nio.entities.ToDo;
import com.quicktutorialz.nio.entities.ToDoDto;
import java.util.List;
import java.util.Optional;

/**
 * 
 * This layer represent the connection to a Blocking Database. 
 * It's not asynchronous, there is no callback. 
 * If I want to do CRUD operations I need to wait.
 * 
 */
public interface ToDoDao {
   
	ToDo create(ToDoDto dto);
    
	Optional<ToDo> read(String id);
    
	List<ToDo> readAll();
    
	Optional<ToDo> update(ToDo toDo);
   
	Boolean delete(String id);

}
