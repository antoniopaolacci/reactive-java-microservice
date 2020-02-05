package com.quicktutorialz.nio.daos.v2;

import com.quicktutorialz.nio.entities.ToDo;
import com.quicktutorialz.nio.entities.ToDoDto;
import io.reactivex.Observable;

import java.util.List;
import java.util.Optional;

/**
 * This layer represent the connection to a Non-Blocking Database.
 * Observable is something which represents an asynchronous access operation, it's a king of promise of a to-do.
 * It's implement a reactive programming model.
 */
public interface ToDoDao {
    
	Observable<ToDo> create(ToDoDto dto);
   
	Observable<Optional<ToDo>> read(String id);
    
	Observable<List<ToDo>> readAll();
    
	Observable<Optional<ToDo>> update(ToDo toDo);
    
	Observable<Boolean> delete(String id);

}
