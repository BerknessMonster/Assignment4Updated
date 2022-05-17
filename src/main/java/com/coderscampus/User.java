package com.coderscampus;

import java.io.Serializable;

public class User implements Serializable, Comparable<User>{
	private String username;
	private String password;
	private String name;
	protected String role;
	public static final long serialVersionUID = 1L;
	public User(String[] usersSplit) {
        this.username = usersSplit[0];
        this.password = usersSplit[1];
        this.name = usersSplit[2];
    }
	public User(String username, String password, String name, String role) {
		this.username = username.trim();
		this.password = password.trim();
		this.name = name.trim();
		this.role = role.trim();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public int compareTo(User that) {
		
		if(this.role.equals(that.role)) {
			return this.username.toLowerCase().compareTo(that.username.toLowerCase());
      }else{
         return that.role.compareTo(this.role);
			
		}
	}

}




