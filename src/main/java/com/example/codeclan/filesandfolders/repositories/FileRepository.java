package com.example.codeclan.filesandfolders.repositories;

import com.example.codeclan.filesandfolders.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
