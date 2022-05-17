package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PopulateUsers {
	public User[] populateUsersFromFile() throws IOException {
		User[] users = new User[20];
		String lineBeingRead = "";
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("users.txt"));
			int i = 0;
			while ((lineBeingRead = bufferedReader.readLine()) != null) {
				String[] usersSplit = new String[4];
				usersSplit = lineBeingRead.split(",");
				try {
				User user = new User(usersSplit[0], usersSplit[1], usersSplit[2], usersSplit[3]);
				users[i] = user;
				i++;
				}
				catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(usersSplit[0].toString());	
				}
			}
			

		} catch (FileNotFoundException e) {
			System.out.println("file not read");
			e.printStackTrace();
		} finally {
			if (bufferedReader != null)
				bufferedReader.close();
		}
		return users;
	}
}