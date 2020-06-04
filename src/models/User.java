package models;

import java.util.Date;

import utility.KeyGenerationUtility;

public class User extends Base {
	private String username;
	private String passsword;
	private String role;

	public User(String username, String password, String role) {
		this.id = KeyGenerationUtility.getUserId();
		this.created = new Date();
		this.updated = new Date();
		this.username = username;
		this.passsword = password;
		this.role = role;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
