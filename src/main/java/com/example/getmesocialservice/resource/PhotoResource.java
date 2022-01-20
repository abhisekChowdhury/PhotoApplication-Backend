package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.CommentService;
import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/photos")
public class PhotoResource {


    @Autowired
    private PhotoService photoService;

    @Autowired
    private FirebaseService firebaseService;

    @Autowired
    private CommentService commentService;


    @PostMapping
    @CrossOrigin
    public Photo savePhoto(@RequestBody @Valid  Photo photo){
        return photoService.savePhoto(photo);
    }


    //get photos
    @GetMapping
    public List<Photo> getAllPhotos(String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser!= null){
            return photoService.getAllPhotos();
        }
        return null;
    }


    //update photos
    @PutMapping
    public Photo updatePhoto(@RequestBody @Valid Photo photo){
        return photoService.updatePhoto(photo);

    }

    @DeleteMapping
    public void deletePhotosById(@RequestParam("id") String id){
        photoService.deletePhotos(id);
    }


    //get photos by ID
    @GetMapping("{id}")
    public List<Photo> getPhotoById(@PathVariable("id") String id, @RequestHeader(name ="idToken") String idToken ) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            return photoService.getPhotoById(id);
        }
        return null;

    }

    //Save comments
    @PostMapping("comments")
    @CrossOrigin
    public Comment saveComment(@RequestBody Comment comment,
                               @RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            return commentService.saveComment(comment);
        }
        return null;

    }

    @GetMapping("{photoId}/comments")
    public List<Comment> getCommentsOfPhotos(@PathVariable("photoId") String photoId,
                                             @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            return commentService.getCommentsOfPhotos(photoId);
        }
        return null;

    }







}
