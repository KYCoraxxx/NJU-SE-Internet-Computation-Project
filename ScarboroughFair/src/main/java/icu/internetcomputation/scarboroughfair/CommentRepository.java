package icu.internetcomputation.scarboroughfair;

import org.springframework.data.repository.CrudRepository;

import icu.internetcomputation.scarboroughfair.entity.Comment;


public interface CommentRepository extends CrudRepository<Comment, Integer>{
    
}
