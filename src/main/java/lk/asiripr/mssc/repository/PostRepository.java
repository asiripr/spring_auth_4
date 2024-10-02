package lk.asiripr.mssc.repository;

import org.springframework.data.repository.ListCrudRepository;

import lk.asiripr.mssc.model.Post;

public interface PostRepository extends ListCrudRepository<Post, Integer>{

}
