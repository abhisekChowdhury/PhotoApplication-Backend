package com.example.getmesocialservice.model;

import com.example.getmesocialservice.Validation.ValidName;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class UserDb {

    @Id
    private String id;
    @NotEmpty @ValidName
    private String name;
    @Email
    private String emailAddress;
    private String profilePicUrl;

    public UserDb(String id, String name, String emailAddress, String profilePicUrl) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.profilePicUrl = profilePicUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }


    @Override
    public String toString() {
        return "UserDb{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", profilePicUrl='" + profilePicUrl + '\'' +
                '}';
    }
}
