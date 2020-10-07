package com.codeclan.example.filesservice.controllers;

import com.codeclan.example.filesservice.models.Folder;
import com.codeclan.example.filesservice.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/folders/{id}")
    public ResponseEntity<Object> updateFolder(@RequestBody Folder folder, @PathVariable Long id) {
        Optional<Folder> folderOptional = folderRepository.findById(id);
        if (!folderOptional.isPresent())
            return new ResponseEntity<>(folder, HttpStatus.NOT_FOUND);
        folder.setId(id);
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.OK);
    }

    @DeleteMapping("/folders/{id}")
    public void deleteFolder(@PathVariable Long id) {
        folderRepository.deleteById(id);
    }
}
