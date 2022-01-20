package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.File;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<File, String> {
    File findByName(String name);


}
