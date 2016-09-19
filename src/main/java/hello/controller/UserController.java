package hello.controller;

import hello.model.persistence.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Кеша on 24.08.2016.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //    ResponseEntity is meant to represent the entire HTTP response.
    @RequestMapping(value="/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> getUsers(){
        Collection<User> users = userService.findAll();
        return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
    }



    @RequestMapping(value = "/api/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    The @RequestBody method parameter annotation indicates that a method parameter should be bound to the value of the HTTP request body
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.create(user);
        if (user == null){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
    }
    @RequestMapping(value = "/api/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.update(user);
        if (updatedUser == null){
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
    }
    @RequestMapping( value = "/api/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        if (userService.findOne(id)==null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping( value = "/api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        if (userService.findOne(id)==null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(userService.findOne(id),HttpStatus.OK);
    }
}
