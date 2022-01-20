package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList<>();
    public User getUser(){
        return new User("him","Canada", 18, "dd" );
    }

    public User saveUser(User user) {
        user.setUserId(userList.size()+1);
        userList.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(int userId) {
        for(User user: userList){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }

    //User user in parameter is with new data needs to be replaced with old data of this passed ID.
    public User updateUser(int userId, User user) {
        for(User u: userList){
            if(u.getUserId() == userId){
                u.setName(user.getName());
                u.setAddress(user.getAddress());
                u.setAge(user.getAge());
                return u;
            }
        }
        return null;
    }

    public User deleteUser(int userId) {
        User deletedUser = null;
        for(User u: userList){
            if(u.getUserId() == userId ){
                deletedUser = u;
                userList.remove(u);
                return deletedUser;
            }
        }
        return deletedUser;
    }
}
