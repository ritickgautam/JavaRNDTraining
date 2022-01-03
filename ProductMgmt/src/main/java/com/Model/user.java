package com.Model;

public class user {
	private int id;
	private String name;
	private long contact;
	private String email;
	private String username;
	private String password;
	
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

}
