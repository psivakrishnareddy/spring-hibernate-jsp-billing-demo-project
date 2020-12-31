package com.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDTO implements Serializable,Comparable<UserDTO>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	@Column(name = "username")
	private String uname;
	
	@Column(name="userpass")
	private String upass;
	
	@Column(name="flag")
	private int flag;
	
	@ManyToOne
	@JoinColumn(name = "roleid")
	private RolesDTO role;
	
	
	public RolesDTO getRole() {
		return role;
	}
	public void setRole(RolesDTO role) {
		this.role = role;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	@Override
	public int compareTo(UserDTO o) {
		if(this.uid==o.uid) {
			return 0;
		}
		else if(this.uid>o.uid) {
			return 1;
		}
		else {
			return -1;
		}
	}
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", flag=" + flag + ", role=" + role
				+ "]";
	}
	
	
}

