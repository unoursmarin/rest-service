package com.example.restservice;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//CRUD services for users
@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> listAll(){
		return repo.findAll();
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public void save(User user) {
		valider(user);
		repo.save(user);
	}
	
	public User get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	
    // Checks if user above 18
    private  boolean dateValider(Date birthdate){

        //Get Year by timezone & birthdate
        LocalDate now = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = birthdate.toInstant();

        Period diff = Period.between(instant.atZone(defaultZoneId).toLocalDate(), now);
		return diff.getYears() > 18;
    }
//Checks country
    private  boolean countryValider(String country){
		return country.equalsIgnoreCase("france");
    }
    
    //Method to call to validate before save so the api doesn't get corrupted
    public void valider(User user) {
		user.setValid(countryValider(user.getCountry()) && dateValider(user.getBirthday()));
    }

}

