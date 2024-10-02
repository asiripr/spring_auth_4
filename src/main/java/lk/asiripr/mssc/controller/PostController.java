package lk.asiripr.mssc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.asiripr.mssc.repository.PostRepository;

@RestController
@RequestMapping
public class PostController {
	private final PostRepository repository;

	public PostController(PostRepository repository) {
		this.repository = repository;
	}

}
