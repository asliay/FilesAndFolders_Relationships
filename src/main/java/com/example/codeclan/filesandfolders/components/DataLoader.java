package com.example.codeclan.filesandfolders.components;

import com.example.codeclan.filesandfolders.models.File;
import com.example.codeclan.filesandfolders.models.Folder;
import com.example.codeclan.filesandfolders.models.User;
import com.example.codeclan.filesandfolders.repositories.FileRepository;
import com.example.codeclan.filesandfolders.repositories.FolderRepository;
import com.example.codeclan.filesandfolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        User bob = new User("Bob");
        userRepository.save(bob);
        User louise = new User("Louise");
        userRepository.save(louise);
        User tina = new User("Tina");
        userRepository.save(tina);
        User linda = new User("Linda");
        userRepository.save(linda);
        User gene = new User("Gene");
        userRepository.save(gene);

        Folder folder1 = new Folder("Folder A", bob);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("Folder B", linda);
        folderRepository.save(folder2);
        Folder folder3 = new Folder("Folder C", tina);
        folderRepository.save(folder3);

        File file1 = new File("Burger_Recipes", "java", 80, folder1);
        fileRepository.save(file1);
        File file2 = new File("Tinas_Dances", "txt", 50, folder1);
        fileRepository.save(file2);
        File file3 = new File("Louise_Pranks", "java", 60, folder2);
        fileRepository.save(file3);
        File file4 = new File("Best_Jokes", "txt", 75, folder3);
        fileRepository.save(file4);
        File file5 = new File("Wine_List", "txt", 60, folder3);
        fileRepository.save(file5);

        folder1.addFile(file1);
        folder1.addFile(file2);
        folderRepository.save(folder1);
        folder2.addFile(file3);
        folderRepository.save(folder2);
        folder3.addFile(file4);
        folder3.addFile(file5);
        folderRepository.save(folder3);

    }
}

