package com.example.codeclan.filesandfolders.controllers;

import com.example.codeclan.filesandfolders.models.File;
import com.example.codeclan.filesandfolders.repositories.FileRepository;
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
    public ResponseEntity<List<File>> getAllFiles() {
        List<File> allFiles = fileRepository.findAll();
        return new ResponseEntity<>(allFiles, HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id) {
        Optional<File> file = fileRepository.findById(id);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> createFile (@RequestBody File newFile) {
        File createdFile = fileRepository.save(newFile);
        return new ResponseEntity<>(createdFile, HttpStatus.CREATED);
    }
}
