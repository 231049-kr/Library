package model;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String name;
	private String pass;
	private int role;
	
	public User() {}
	public User(String id, String name, String pass, int role) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.role = role;
	}
	
	// Getter メソッド
	public String getId() {return id;}
	public String getName() {return name;}
	public String getPass(){return pass;}
	public int getRole() {return role;}
}

