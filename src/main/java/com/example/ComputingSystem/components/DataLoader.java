package com.example.ComputingSystem.components;

import com.example.ComputingSystem.models.File;
import com.example.ComputingSystem.models.FileType;
import com.example.ComputingSystem.models.Folder;
import com.example.ComputingSystem.models.User;
import com.example.ComputingSystem.repositories.FileRepository;
import com.example.ComputingSystem.repositories.FolderRepository;
import com.example.ComputingSystem.repositories.UserRepository;
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
        User abbie = new User("Abbie");
        userRepository.save(abbie);

        Folder files = new Folder("Files", abbie);
        folderRepository.save(files);

        Folder images = new Folder("Images", abbie);
        folderRepository.save(images);

        Folder projects = new Folder("Projects", abbie);
        folderRepository.save(projects);

        Folder documents = new Folder("Documents", abbie);
        folderRepository.save(documents);

        File image = new File("Image of sun", FileType.JPEG, 100, images);
        fileRepository.save(image);

        File document = new File("CV", FileType.TXT, 200, documents);
        fileRepository.save(document);

        File file = new File("Misc Item", FileType.TXT, 200, files);
        fileRepository.save(file);

        File project = new File("Java Project", FileType.JAVA, 1000, projects);
        fileRepository.save(project);

        abbie.addFolderToUser(files);
        abbie.addFolderToUser(images);
        abbie.addFolderToUser(projects);
        abbie.addFolderToUser(documents);
        userRepository.save(abbie);

        files.addFileToFolder(file);
        folderRepository.save(files);

        images.addFileToFolder(image);
        folderRepository.save(images);

        projects.addFileToFolder(project);
        folderRepository.save(projects);

        documents.addFileToFolder(document);
        folderRepository.save(documents);
    }
}
