package com.example.ComputingSystem;

import com.example.ComputingSystem.models.File;
import com.example.ComputingSystem.models.FileType;
import com.example.ComputingSystem.models.Folder;
import com.example.ComputingSystem.models.User;
import com.example.ComputingSystem.repositories.FileRepository;
import com.example.ComputingSystem.repositories.FolderRepository;
import com.example.ComputingSystem.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputingSystemApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createUserAndFolderAndAddFolder(){
		User user = new User("Tina");
		userRepository.save(user);

		Folder folder = new Folder("Images", user);
		folderRepository.save(folder);

		user.addFolderToUser(folder);
		userRepository.save(user);
	}

	@Test void createFolderAndFileAndAddFile(){
		User user = new User("Tina");
		userRepository.save(user);

		Folder folder = new Folder("Images", user);
		folderRepository.save(folder);

		File file = new File("Image of sun", FileType.JPEG, 100, folder);
		fileRepository.save(file);

		folder.addFileToFolder(file);
		folderRepository.save(folder);
	}

}
