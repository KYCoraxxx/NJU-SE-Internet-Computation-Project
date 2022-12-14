package icu.internetcomputation.scarboroughfair.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import icu.internetcomputation.scarboroughfair.CommentRepository;
import icu.internetcomputation.scarboroughfair.ForumPostRepository;
import icu.internetcomputation.scarboroughfair.entity.Comment;
import icu.internetcomputation.scarboroughfair.entity.ForumPost;

@Service
public class ForumService {
    @Resource
    CommentRepository commentRepository;

    @Resource
    ForumPostRepository forumPostRepository;


    public Iterable<ForumPost> findAllPost()
    {
        return forumPostRepository.findAll();
    }

    public Iterable<Comment> findAllComment()
    {
        return commentRepository.findAll();
    }

    public ForumPost findForumPost(int id){
        return forumPostRepository.findById(id).orElse(null);
    }

    public Comment findComment(int id){
        return commentRepository.findById(id).orElse(null);
    }

}
