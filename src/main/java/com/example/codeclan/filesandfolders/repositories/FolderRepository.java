package com.example.codeclan.filesandfolders.repositories;

import com.example.codeclan.filesandfolders.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
