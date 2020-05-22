package com.vob.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vob.workshopmongo.domain.User;
import com.vob.workshopmongo.repository.UserRepository;
import com.vob.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id)
	{
		Optional<User> user = repo.findById(id); // throws IllegalArgumentException if 'id' is null
 
		return user.orElseThrow(() -> new ObjectNotFoundException(String.format("Requested id=%s does not exist", id)));
	}
	
}
