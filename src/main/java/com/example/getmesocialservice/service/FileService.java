package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.example.getmesocialservice.model.File;
import com.example.getmesocialservice.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;


//upload file on amazon S3 bucket.
@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public File upload(MultipartFile file) {
        File fileData = new File();
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIARV3O4DWZHNMZRPON", "b+xgLZJN77wzYtDlJUKgNuY5HfFZrOzY8QqSXg/G");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_2).build();
        try {

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            //BucketName: which is created using S3 services: frontend-nov21, in that bucket you are going to store file....
           s3.putObject("backend-spring2021",file.getOriginalFilename(), file.getInputStream(), metadata);
           System.out.println(s3.getObject( "backend-spring2021",file.getOriginalFilename()) );

             String name = file.getOriginalFilename();
            URL imagePath = s3.getUrl("backend-spring2021", name);
            fileData.setImagePath(imagePath.toString());
            fileData.setName(name);
            return fileRepository.save(fileData);

        }
        catch (AmazonServiceException | IOException e) {
            e.printStackTrace();
            return null;

        }
    }

//key - filename in the aws s3 bucket
    public S3Object getFile(String key) {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIARV3O4DWZHNMZRPON", "b+xgLZJN77wzYtDlJUKgNuY5HfFZrOzY8QqSXg/G");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_2).build();
        return s3.getObject("backend-spring2021",key);
    }


    public void deleteFile(String key) {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIARV3O4DWZHNMZRPON", "b+xgLZJN77wzYtDlJUKgNuY5HfFZrOzY8QqSXg/G");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_2).build();
        s3.deleteObject("backend-spring2021",key);
    }


    public S3Object getFileByFileId(String fileId) {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIARV3O4DWZHNMZRPON", "b+xgLZJN77wzYtDlJUKgNuY5HfFZrOzY8QqSXg/G");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_2).build();

        Optional<File> fileObj = fileRepository.findById(fileId);
        if(fileObj.isPresent()) {
            File existingFile = fileObj.get();
            String name = existingFile.getName();
            //operate on existingCustomer
        } else {
            System.out.println("no customer in the repo..");
        }

            return s3.getObject("backend-spring2021", fileObj.get().getName());
    }


    public List<File> getAllFiles() {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIARV3O4DWZHNMZRPON", "b+xgLZJN77wzYtDlJUKgNuY5HfFZrOzY8QqSXg/G");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_2).build();

        return (List<File>) fileRepository.findAll();


    }
}
