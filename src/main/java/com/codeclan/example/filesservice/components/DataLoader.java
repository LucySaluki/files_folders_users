package com.codeclan.example.filesservice.components;

import com.codeclan.example.filesservice.models.File;
import com.codeclan.example.filesservice.models.Folder;
import com.codeclan.example.filesservice.models.User;
import com.codeclan.example.filesservice.repositories.FileRepository;
import com.codeclan.example.filesservice.repositories.FolderRepository;
import com.codeclan.example.filesservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    FileRepository fileRepository;
    public DataLoader() {
    }
    public void run(ApplicationArguments args) {
        User user1 = new User("Joe Bloggs");
        userRepository.save(user1);
        User user2 = new User("Fred Smith");
        userRepository.save(user2);
        Folder folder1 = new Folder("Java", user1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("Python", user1);
        folderRepository.save(folder2);
        Folder folder3 = new Folder("CSS", user2);
        folderRepository.save(folder3);
        File file1=new File("Java Shortcuts", "txt", 20, folder1);
        fileRepository.save(file1);
        File file2=new File("Java Documentation", "docx", 240, folder1);
        fileRepository.save(file2);
        File file3=new File("Python Shortcuts", "txt", 10, folder2);
        fileRepository.save(file3);
        File file4=new File("CSS guide", "pdf", 1400, folder3);
        fileRepository.save(file4);
        user1.addFolderToUser(folder1);
        user1.addFolderToUser(folder2);
        user2.addFolderToUser(folder3);
        userRepository.save(user1);
        userRepository.save(user2);
        folder1.addFileToFolder(file1);
        folder1.addFileToFolder(file2);
        folder2.addFileToFolder(file3);
        folder3.addFileToFolder(file4);
        folderRepository.save(folder1);
        folderRepository.save(folder2);
        folderRepository.save(folder3);

    }
}
