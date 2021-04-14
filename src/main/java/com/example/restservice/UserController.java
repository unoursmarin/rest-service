package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javassist.NotFoundException;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    private final UserRepository userRepository;
    
    @Autowired
    private UserService service;

    //Get all users
    @GetMapping("/users")
    public List<User> list(){
	return service.listAll();
    }
    
    UserController(UserRepository repository) {
        this.userRepository = repository;
    }
    
    // If the User is not existing return a proper error code
    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
    	try {
    		User user= service.get(id);
    		return new ResponseEntity<>(user, HttpStatus.OK);
    	}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	
    }
    
    // Add a new user
    @PostMapping("/users")
    public void add(@RequestBody User user) {
    	
    	service.save(user);
    }
    
    //edit user
    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
    	try {
    		User existUser=service.get(id);
    		service.save(user);
    		return new ResponseEntity<>(HttpStatus.OK);
    	}catch(NoSuchElementException e) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    // delete user
    @PostMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
    	try {
    		service.delete(id);
    		return new ResponseEntity<>(HttpStatus.OK);
    	}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    
    }
    
    }
