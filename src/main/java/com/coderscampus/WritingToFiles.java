package com.coderscampus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingToFiles {
	public void writeToFile(User[] users, UserService userService) throws IOException {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter("users.txt"));

			for (User user : users) {

				writer.write(userService.getCurrentUser(user));
				if (user.getRole().equals("super_user")) {

				} else {

				}
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
