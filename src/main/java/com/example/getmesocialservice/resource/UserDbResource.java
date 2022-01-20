package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.exception.InvalidIdToken;
import com.example.getmesocialservice.exception.RestrictedInfoException;
import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.model.UserDb;
import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.service.UserDbService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController   //this annotation applied to a class as request handler, it's used to create Restful web services using spring MVC.
@RequestMapping("/api/users")     //rest endpoint path starts with
@CrossOrigin
//all the methods in the class starts with rest server
public class UserDbResource {

    //using this annotation,
    // It's gonna create object and transfer to the spring container
    @Autowired
    private UserDbService userService;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping("/allUsers")   //getting all the data in the list
    public List<UserDb> getAllUsers() throws IOException {
            return userService.getAllUsers();
    }

    //get current user data
    @GetMapping("/me")
    @CrossOrigin
    public UserDb getById(@RequestHeader(name ="idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null) {
            System.out.println(idToken);
            System.out.println("in resource " + firebaseUser.getEmail());

            return userService.getByID(idToken, firebaseUser.getEmail());
        }
        return null;
    }

    //Add new User0
    //@valid: it would try to validate all field of post depends on annotation of model classes
    @PostMapping("/addNewUser")
    @CrossOrigin
    public UserDb saveUser(@RequestBody @Valid UserDb user /*, @RequestHeader(name="idToken") String idToken*/) throws IOException, FirebaseAuthException, InvalidIdToken {
        //FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        //if id token is valid then you can save the user info.
        if(user!= null) {
             return userService.saveUser(user);
        }
//        if(idToken == null){
//            throw new InvalidIdToken();
//        }
        return  null;
    }
    // Invalid IdToken Custom Exception
    @ExceptionHandler(InvalidIdToken.class)
    public String invalidIdToken(InvalidIdToken ex){
        return ex.getMessage();
    }


    @GetMapping("/find-by-email")
    public List<UserDb> getByAddress(@RequestParam("email") String email) throws RestrictedInfoException{
        if(email.equalsIgnoreCase("root")) {
            throw new RestrictedInfoException();
        }
       return userService.getByEmailAddress(email);
    }

    @GetMapping("/findByName")
    public List<UserDb> getByName(@RequestParam(name = "name") String name){
       return userService.getByName(name);
    }

    @GetMapping("/findByNameStartingWith")
    public List<UserDb> getByNameStartingwith(@RequestParam(name = "nameStartingLetter") String name){
        return userService.getByNameStartingwith(name);
    }

    //update user data
    @PutMapping("/updateUser")
    public UserDb updateUser(@RequestBody UserDb userDb, @RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!= null){
            return userService.updateUser(userDb);
        }
        return null;
    }

    //update profile photoURL
    @PutMapping("me/profilePhoto")
    @CrossOrigin
    public UserDb updateProfilePhotoUrl(@RequestParam("profilePicUrl") String profilePicUrl, @RequestHeader("idToken") String idToken)
            throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!= null) {
            return userService.updateProfilePhotoUrl(profilePicUrl, firebaseUser.getEmail());
        }
        return null;
    }



    @DeleteMapping
    public void deleteUser(@RequestParam(name = "userID") String userId) {
        userService.deleteUser(userId);
    }







    /*//getting data in json format
    @GetMapping("/user")     //return the values in json format, getting data
    public User getUser(){
        return userService.getUser();
    }


    //getting data based on userId
    //whatever comes here in Json format based on parameter variable(field) userId.
    //taking the path endpoint-userId, that value comes here in parameter would be converted into userID
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }


    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestParam(name = "userId") int userId){
        return userService.deleteUser(userId);

    }
*/
}

