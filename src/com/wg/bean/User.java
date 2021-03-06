package com.wg.bean;

import java.util.Date;

public class User{
	int number;
	private Long id;
	private String username;
	private String password;
	
	private Date createdDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    
	
	public User() {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	public int hashCode(){ 
		return number; 
	} 
	public boolean equals(Object o){ 
	return (o instanceof User) && (number==((User)o).number)
			&&(id==((User)o).id)&&(username==((User)o).username)
			&&(password==((User)o).password); 
	}
	
}
