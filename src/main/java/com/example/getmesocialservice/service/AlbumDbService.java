package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.AlbumDb;
import com.example.getmesocialservice.repository.AlbumDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumDbService {

    @Autowired
    private AlbumDbRepository albumDbRepository;

    public AlbumDb saveAlbum(AlbumDb album) {
        return albumDbRepository.save(album);
    }

    public List<AlbumDb> getAllAlbums() {
        return albumDbRepository.findAll();
    }

    public List<AlbumDb> getById(String id) {
        return albumDbRepository.findAllById(id);
    }

    public AlbumDb updateAlbum(AlbumDb albumDb) {
        return albumDbRepository.save(albumDb);
    }

    public void deleteAlbum(String id) {
        albumDbRepository.deleteById(id);
    }

    public AlbumDb updateCoverPhoto(String coverPhotoUrl, String albumId) {
        AlbumDb album;
        if(albumDbRepository.findById(albumId).isPresent()){
            album = albumDbRepository.findById(albumId).get();
            album.setCoverPhotoUrl(coverPhotoUrl);
            albumDbRepository.save(album);
            return album;
        }
        return null;
    }
}
