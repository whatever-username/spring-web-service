package hello.controller;

import hello.model.persistence.Task;
import hello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by qwe on 15.08.2016.
 */
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    //    ResponseEntity is meant to represent the entire HTTP response.
    @RequestMapping(value="/api/tasks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Task>> getTasks(){
        Collection<Task> tasks = taskService.findAll();
        return new ResponseEntity<Collection<Task>>(tasks, HttpStatus.OK);
    }



    @RequestMapping(value = "/api/tasks", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    The @RequestBody method parameter annotation indicates that a method parameter should be bound to the value of the HTTP request body
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = taskService.create(task);
        if (task == null){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<Task>(savedTask,HttpStatus.CREATED);
    }
    @RequestMapping(value = "/api/tasks", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        Task updatedTask = taskService.update(task);
        if (updatedTask == null){
            return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Task>(updatedTask,HttpStatus.OK);
    }
    @RequestMapping( value = "/api/tasks/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable("id") int id){
        if (taskService.findOne(id)==null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        taskService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping (value = "/api/tasks/{param}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Task>> findByType(@PathVariable("param")String param){
        if (param.matches("\\d{1,}")){
            Collection<Task> tasks = new ArrayList<>();
            tasks.add(taskService.findOne(Integer.parseInt(param)));
            return new ResponseEntity<Collection<Task>>(tasks,HttpStatus.OK);
        }
        else if (param.equals("offers") || param.equals("requests")){
            return new ResponseEntity<Collection<Task>>(taskService.findByType(param), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping (value= "/api/test", method = RequestMethod.GET)
    public ResponseEntity<String> test(){
        return new ResponseEntity("Test",HttpStatus.OK);
    }
}
