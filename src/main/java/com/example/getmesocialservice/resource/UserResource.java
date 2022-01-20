package com.example.getmesocialservice.resource;


import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController             //rest endpoint
@RequestMapping("/api")     //rest endpoint path starts with
//all the methods in the class starts with rest server
public class UserResource {

    //using this annotation,
    // it's gonna create object and transfer to the spring container
    @Autowired
    private UserService userService;



    //getting data in json format
    @GetMapping("/user")     //return the values in json format, getting data
    public User getUser(){
        return userService.getUser();
    }

    //send request body to save the data in json format., sending data
    @PostMapping
    public User saveUser(@RequestBody @Valid User user) throws IOException {
            return userService.saveUser(user);
    }

    @GetMapping("/allUsers")    //getting all the data in the list
    public List<User> getAllUsers(){
        return userService.getAllUsers();
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


}
