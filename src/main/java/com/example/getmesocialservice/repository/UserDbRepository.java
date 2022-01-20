package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.UserDb;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserDbRepository extends MongoRepository<UserDb, String> {

    List<UserDb> findAllByName(String name);
    List<UserDb> findAllByNameStartingWith(String startingLetter);

    List<UserDb> findAllByEmailAddress(String email);
}
