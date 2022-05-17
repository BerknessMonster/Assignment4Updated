package com.coderscampus;

import java.io.IOException;


public class Application {

	public static void main(String[] args) throws IOException {
		boolean loggedInUserBoolean = false;
		PopulateUsers populateUsers = new PopulateUsers();
		UserService userService = new UserService();
		WritingToFiles writingToFiles = new WritingToFiles();
		/////////// INSTANTIATIONS///////////////////
		User[] users = populateUsers.populateUsersFromFile();
		User loggedInUser = userService.inputsAndComparingUserByUsernameAndPassword(users);
		
		Integer option = userService.loggedInUserPromptOptions(loggedInUser, loggedInUserBoolean, users, userService);
		writingToFiles.writeToFile(users, userService);
		

	}
}