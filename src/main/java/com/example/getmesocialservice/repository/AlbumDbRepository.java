package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.AlbumDb;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlbumDbRepository extends MongoRepository<AlbumDb, String> {

    List<AlbumDb> findAllById(String id);



}
