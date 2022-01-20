package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.UserDb;
import com.example.getmesocialservice.repository.UserDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDbService {
    @Autowired
    private UserDbRepository userRepository;
    @Autowired
    private FirebaseService firebaseService;


    public UserDb saveUser(UserDb user) {
        return userRepository.save(user);
    }

    public List<UserDb> getAllUsers() {
        return userRepository.findAll();
    }


    public UserDb getByID(String idToken, String email ) {

        List<UserDb> userDbList = userRepository.findAll();
        System.out.println("---------ok----------"+userDbList);
        for(UserDb user: userRepository.findAll()){

            System.out.print("------------user list-email-------------"+ user.toString());
            System.out.print("------------user data-------------"+ user.getProfilePicUrl());

            if(user.getEmailAddress().equalsIgnoreCase(email)) {
                System.out.println("---------in service - email equal-firebase----------" + user.getEmailAddress());
                return user;
            }
        }
        return null;
    }


    public UserDb updateUser(UserDb userDb) {
        return userRepository.save(userDb);

    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<UserDb> getByEmailAddress(String email) {
        return userRepository.findAllByEmailAddress(email);
    }

    public  List<UserDb> getByName(String name) {
        return userRepository.findAllByName(name);
    }

    public List<UserDb> getByNameStartingwith(String name) {
        return userRepository.findAllByNameStartingWith(name);

    }

    public UserDb updateProfilePhotoUrl(String profilePicUrl, String email) {
        List<UserDb> userDbList =  userRepository.findAll();
        for(UserDb user : userDbList){
            if(user.getEmailAddress().equalsIgnoreCase(email)){
                user.setProfilePicUrl(profilePicUrl);
                userRepository.save(user);
                return user;
            }
        }

          return null;
    }





 /*
    public User getUser() {
        return userRepository.getUser();
    }




    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    public User updateUser(int userId, User user) {
        return userRepository.updateUser(userId, user);
    }

    public User deleteUser(int userId) {
        return userRepository.deleteUser(userId);
    }*/

}
