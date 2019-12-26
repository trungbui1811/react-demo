package com.react.model;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
	@SequenceGenerator(name = "userIdSeq", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @Id
    @Column(name = "USER_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    private Long userId;
	@Column(name = "FULL_NAME")
    private String fullName;
	@Column(name = "USER_NAME")
    private String userName;
	@Column(name = "CELLPHONE")
    private String cellphone;
	@Column(name = "EMAIL")
    private String email;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
