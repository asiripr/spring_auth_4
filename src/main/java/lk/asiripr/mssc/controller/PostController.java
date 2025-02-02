package lk.asiripr.mssc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.asiripr.mssc.model.Post;
import lk.asiripr.mssc.repository.PostRepository;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	private final PostRepository repository;

	public PostController(PostRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Post> findAll(){
		return repository.findAll();
	}

}
