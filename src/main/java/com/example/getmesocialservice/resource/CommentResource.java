package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.service.CommentService;
import com.example.getmesocialservice.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;


    @Autowired
    private FirebaseService firebaseService;


    @PostMapping
    public Comment saveComment(@RequestBody @Valid Comment comment){
        return commentService.saveComment(comment);
    }


    @GetMapping
    public List<Comment> getAllComments(@RequestHeader(name ="idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!= null){
            return commentService.getAllComments();
        }
        return null;
    }


    @GetMapping("/find-by-id")
    public List<Comment> getByID(String id) {
        return commentService.getById(id) ;
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);

    }

    @DeleteMapping
    public void deleteComment(String id){
        commentService.deleteComment(id);
    }

}
