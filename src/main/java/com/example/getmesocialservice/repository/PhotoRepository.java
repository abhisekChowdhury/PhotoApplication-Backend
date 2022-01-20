package com.example.getmesocialservice.repository;


import com.example.getmesocialservice.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhotoRepository extends MongoRepository<Photo, String> {

    List<Photo> findAllById(String id);

    List<Photo> findPhotosByAlbumId(String albumId);
}
