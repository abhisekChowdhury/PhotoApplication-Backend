package com.example.getmesocialservice.resource;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.example.getmesocialservice.model.File;
import com.example.getmesocialservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileResource {

    @Autowired
    private FileService fileService;

    //Multipartfile: when you are doing upload using browser,
    // which contains: type, length, etc. of file.
    @CrossOrigin
    @PostMapping("/upload")
    public File upload(@RequestParam(name = "file")MultipartFile file) throws IOException {
        return fileService.upload(file);
    }

    @GetMapping("/view")
    public void view(@RequestParam(name = "key") String key, HttpServletResponse response ) throws IOException {
       S3Object object = fileService.getFile(key);
       response.setContentType(object.getObjectMetadata().getContentType());
       response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> download(@PathVariable("fileId") String fileId) throws IOException {
        S3Object object= fileService.getFileByFileId(fileId);

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                    .header(Headers.CONTENT_DISPOSITION, "attachment; filename = \""+fileId+ "\"")
                    .body(new ByteArrayResource(object.getObjectContent().readAllBytes())) ;
    }

    @GetMapping("/show/{fileId}")
    @CrossOrigin
    public void showFile(@PathVariable("fileId") String fileId, HttpServletResponse response) throws IOException {
        S3Object object = fileService.getFileByFileId(fileId);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());

    }

    @GetMapping("/allFiles")
    @CrossOrigin()
    public List<File> showAllFiles(HttpServletResponse response) throws IOException {
        List<File>  files = fileService.getAllFiles( );
        //response.setContentType(object.getObjectMetadata().getContentType());
        //response.getOutputStream().write(object.getObjectContent().readAllBytes());
return files;
    }





    //delete files
    @DeleteMapping
    public void delete(@RequestParam(name = "key") String key){
        fileService.deleteFile(key);
    }





}
