package com.example.codeclan.filesandfolders.controllers;

import com.example.codeclan.filesandfolders.models.File;
import com.example.codeclan.filesandfolders.models.Folder;
import com.example.codeclan.filesandfolders.repositories.FolderRepository;
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
    public ResponseEntity<List<Folder>> getAllFolders() {
        List<Folder> allFolders = folderRepository.findAll();
        return new ResponseEntity<>(allFolders, HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id) {
        Optional<Folder> folder = folderRepository.findById(id);
        return new ResponseEntity<>(folder, HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> createFolder (@RequestBody Folder newFolder) {
        Folder createdFolder = folderRepository.save(newFolder);
        return new ResponseEntity<>(createdFolder, HttpStatus.CREATED);
    }
}
