package com.coderscampus;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UserService {
	private Scanner scanner = new Scanner(System.in);
	WritingToFiles writingToFiles = new WritingToFiles();

	public User inputsAndComparingUserByUsernameAndPassword(User[] users) {
		boolean loggedInUserBoolean = false;
		String userInputEmail = null;
		String userInputPassword = null;
		for (int i = 0; i < 6; i++) {
			if (i >= 5) {
				System.out.println("Too many attempts, you are locked out.");
				System.exit(i);
			} else {
				System.out.println("Enter your email");
				userInputEmail = scanner.nextLine();
				System.out.println("Enter your password");
				userInputPassword = scanner.nextLine();
			}
			for (User user : users) {
				if (userInputEmail.equalsIgnoreCase(user.getUsername()) && userInputPassword.equals(user.getPassword())) {
					System.out.println("Welcome " + user.getName());
					loggedInUserBoolean = true;

					return user;
				}

			}
			if (loggedInUserBoolean == false) {
				System.out.println("Please enter a valid username and password");
			}

		}
		return null;

	}

	private void updateUsername(User loggedInUser, User[] users, UserService userService) throws IOException {
		System.out.println("What would you like your new username to be?");
		String username = scanner.nextLine();
		loggedInUser.setUsername(username.toLowerCase());
		loggedInUserPromptOptions(loggedInUser, true, users, userService);
	}

	private void chooseAnotherUserToLoginAs(User loggedInUser, User[] users, UserService userService) throws IOException {
		System.out.println("Who would you to login as? (Type in a valid username)");
		String userEntered = scanner.nextLine();
		for (User user : users) {
			if (userEntered.equalsIgnoreCase(user.getUsername())) {
				System.out.println("Welcome " + user.getName());

				loggedInUser = user;
				loggedInUserPromptOptions(loggedInUser, true, users, userService);
			}


		}

	}

	private void updatePassword(User loggedInUser, boolean loggedInUserBoolean, User[] users, UserService userService) throws IOException {
		System.out.println("What would you like your new password to be? ");
		String password = scanner.nextLine();
		loggedInUser.setPassword(password);
		System.out.println(password);
		loggedInUserPromptOptions(loggedInUser, loggedInUserBoolean, users, userService);
	}

	private void updateName(User loggedInUser, boolean loggedInUserBoolean, User[] users, UserService userService) throws IOException {
		System.out.println("What would you like your new name to be?");
		String name = scanner.nextLine();
		loggedInUser.setName(name);
		System.out.println(name);
		loggedInUserPromptOptions(loggedInUser, loggedInUserBoolean, users, userService);
	}

	public int loggedInUserPromptOptions(User loggedInUser, boolean loggedInUserBoolean, User[] users, UserService userService) throws IOException {
		String option = "";
		if (loggedInUserBoolean = true) {
			System.out.println("----------");
			System.out.println("Please choose from the following options:");
			if (loggedInUser.getRole().equals("super_user")) {
				System.out.println("(0) Log in as another user ");
				System.out.println("(1) Update username");
				System.out.println("(2) Update password");
				System.out.println("(3) Update name");
				System.out.println("(4) Exit");
				option = scanner.nextLine();
			} else {
				System.out.println("(1) Update username");
				System.out.println("(2) Update password");
				System.out.println("(3) Update name");
				System.out.println("(4) Exit");
				option = scanner.nextLine();
			}
			if (option.trim().equals("")) {
				throw new RuntimeException("throwing runtime excpetion");
			} else if (Integer.parseInt(option) == 0) {
				chooseAnotherUserToLoginAs(loggedInUser, users, userService);
			} else if (Integer.parseInt(option) == 1) {
				updateUsername(loggedInUser, users, userService);
			} else if (Integer.parseInt(option) == 2) {
				updatePassword(loggedInUser, loggedInUserBoolean, users, userService);
			} else if (Integer.parseInt(option) == 3) {
				updateName(loggedInUser, loggedInUserBoolean, users, userService);
			} else if (Integer.parseInt(option) == 4) {
				Arrays.sort(users);
				writingToFiles.writeToFile(users, userService);
				System.out.println("See you next time");
				System.exit(0);

			}
		}
		return Integer.parseInt(option);

	}

	public String getCurrentUser(User user) {
	
		return user.getUsername() + ", " + user.getPassword() + ", " + user.getName() + ", " + user.getRole() + "\n ";
	}
}