package com.example.getmesocialservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {

    @Id
    private String id;
    private String name;
    private String description;
    private String imagePath;


}
