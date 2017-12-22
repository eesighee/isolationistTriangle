package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="USER_ROLES")
public class UserRole {
	
	
	@Id
	@Column(name="role_id")
	@SequenceGenerator(allocationSize=1,name="roleIdSeq",sequenceName="ROLE_ID_SEQ")
	@GeneratedValue(generator="roleIdSeq",strategy=GenerationType.SEQUENCE)
	private Integer roleId;
	
	@Column(name="user_role")
	private String userRole;

	public UserRole() {}
	
	public UserRole(String userRole) {
		super();
		this.userRole = userRole;
	}
			
	public UserRole(Integer roleId, String userRole) {
		super();
		this.roleId = roleId;
		this.userRole = userRole;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", userRole=" + userRole + "]";
	}
	
}
