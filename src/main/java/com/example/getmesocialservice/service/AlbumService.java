package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album getAlbum() {
        return albumRepository.getAlbum();

    }

    public Album saveAlbum(Album album) {
        return albumRepository.saveAlbum(album);
    }

    public List<Album> getAllAlbums() {
        return albumRepository.getAllAlbums();
    }

    public Album getAlbumById(int albumId) {
        return albumRepository.getAlbumById(albumId);
    }

    public Album updateAlbum(int albumId, Album album) {
        return albumRepository.updateAlbum(albumId,album );
    }

    public Album deleteAlbum(int albumId) {
        return albumRepository.deleteAlbum(albumId);
    }
}
