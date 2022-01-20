package com.example.getmesocialservice.model;

import com.example.getmesocialservice.Validation.ValidNamePhoto;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Photo {
    @Id
    private String id;
    private String albumId;
    private String photoUrl;

    @NotEmpty @ValidNamePhoto
    private String createdBy;
    private Date dateCreated;


    public Photo(String albumId, String photoUrl, String createdBy, Date dateCreated) {
        this.albumId = albumId;
        this.photoUrl = photoUrl;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
