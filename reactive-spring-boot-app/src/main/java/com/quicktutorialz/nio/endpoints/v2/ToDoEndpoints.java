package com.quicktutorialz.nio.endpoints.v2;

import com.mawashi.nio.annotations.Api;
import com.mawashi.nio.utils.Action;
import com.mawashi.nio.utils.Endpoints;
import com.quicktutorialz.nio.daos.v2.ToDoDao;
import com.quicktutorialz.nio.daos.v2.ToDoDaoImpl;
import com.quicktutorialz.nio.entities.ResponseDto;
import com.quicktutorialz.nio.entities.ToDo;
import com.quicktutorialz.nio.entities.ToDoDto;
import io.reactivex.Observable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author alessandroargentieri
 *
 * Non-reactive development (api v2)
 */
public class ToDoEndpoints extends Endpoints {

    ToDoDao toDoDao = ToDoDaoImpl.getInstance();
    
    
    /* Observable is a sort of promise. We need to define a stack: 
     * - Take our input request in a Observable.
     * - Transform, via map operator, one Observable in another Observable.
     * - The output of a phase is exactly the input of another. 
     * - .map transform the input of the previous Observable and trasform in order to get an input 
     * - toDoDao.create(input) is now the output
     * - .subscribe we need to return to the subscriber when the data are transformed
     */
    
    @Api(path = "/api/v2/create", method = "POST", consumes = "application/json", produces = "application/json")
    Action createToDo = (HttpServletRequest request, HttpServletResponse response) -> {
        Observable.just(request)
                  .map(req -> (ToDoDto) getDataFromJsonBodyRequest(request, ToDoDto.class))
                  .flatMap(input -> toDoDao.create(input))  // Observable of an Observable... we need to use flatMap
                  .subscribe(output -> toJsonResponse(request, response, new ResponseDto(200, output)));
    };

    @Api(path = "/api/v2/read/{id}", method = "GET", produces = "application/json")
    Action readToDo = (HttpServletRequest request, HttpServletResponse response) -> {
        Observable.just(request)
                  .map(req -> getPathVariables(request).get("id")) // req is a sort of alias
                  .flatMap(id -> toDoDao.read(id))
                  .subscribe(output -> toJsonResponse(request,
                                                      response,
                                                      new ResponseDto(200, output.isPresent() ? output.get() : "todo not found")));
    };

    @Api(path = "/api/v2/read", method = "GET", produces = "application/json")
    Action readAllToDos = (HttpServletRequest request, HttpServletResponse response) -> {
        Observable.just(request)
                .flatMap(req -> toDoDao.readAll()) // toDoDao returns an Observable
                .subscribe(output  -> toJsonResponse(request, response, new ResponseDto(200, output)),
                           error   -> toJsonResponse(request, response, new ResponseDto(200, error))
                );
        
       /*
        * We can cloase the subscribe or we can define an error. 
        * In the case of error we need the map the same message.
        */
    };

    @Api(path = "/api/v2/update", method = "POST", consumes = "application/json", produces = "application/json")
    Action updateToDo = (HttpServletRequest request, HttpServletResponse response) -> {
        Observable.just(request)
                  .map(req -> (ToDo) getDataFromJsonBodyRequest(request, ToDo.class))
                  .flatMap(input -> toDoDao.update(input))
                  .subscribe(output -> toJsonResponse(request,
                                                      response,
                                                      new ResponseDto(200, output.isPresent() ? output.get() : "todo not updated")));
    };

    @Api(path = "/api/v2/delete/{id}", method = "GET", produces = "application/json")
    Action deleteToDo = (HttpServletRequest request, HttpServletResponse response) -> {
        Observable.just(request)
                  .map(req -> getPathVariables(request).get("id"))
                  .flatMap(id -> toDoDao.delete(id))
                  .subscribe(result -> toJsonResponse(request,
                                                      response,
                                                      new ResponseDto(200, result ? "todo deleted": "todo not found")));
    };

    public ToDoEndpoints(){
        setEndpoint("/api/v2/create", createToDo);
        setEndpoint("/api/v2/read/{id}", readToDo);
        setEndpoint("/api/v2/read", readAllToDos);
        setEndpoint("/api/v2/update", updateToDo);
        setEndpoint("/api/v2/delete/{id}", deleteToDo);
    }
}