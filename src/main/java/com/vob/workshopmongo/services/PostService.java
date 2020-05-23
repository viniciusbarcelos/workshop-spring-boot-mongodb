package com.vob.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vob.workshopmongo.domain.Post;
import com.vob.workshopmongo.repository.PostRepository;
import com.vob.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id); // throws IllegalArgumentException if 'id' is null

		return user.orElseThrow(() -> new ObjectNotFoundException(String.format("Requested id=%s does not exist", id)));
	}

	public List<Post> findByTitle(String text) {

		return repo.findByTitleContainingIgnoreCase(text);

	}

}
