package com.codeclan.example.filesservice.controllers;

import com.codeclan.example.filesservice.models.File;
import com.codeclan.example.filesservice.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

    @PutMapping(value = "/files/{id}")
    public ResponseEntity<Object> updateFile(@RequestBody File file, @PathVariable Long id) {
        Optional<File> fileOptional = fileRepository.findById(id);
        if (!fileOptional.isPresent())
            return new ResponseEntity<>(file, HttpStatus.NOT_FOUND);
        file.setId(id);
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @DeleteMapping("/files/{id}")
    public void deleteFile(@PathVariable Long id) {
        fileRepository.deleteById(id);
    }
}
