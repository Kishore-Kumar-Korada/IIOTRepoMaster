package com.kishorekumarkorada.IIOTDataVisualizer.model;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "iiot_user", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class IIOTUserModel {
	
	@Id
	@Column(name="user_name")
	private String userName;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="user_status")
	private String userStatus;
	
	@Column(name = "last_login", columnDefinition = "DATETIME")
	private LocalDateTime lastLogin;
	
	@Column(name="created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdOn;
	
	@Column(name="updated_on", columnDefinition = "DATETIME")
	private LocalDateTime updatedOn;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name="user_name",referencedColumnName = "user_name"),
			inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id")
	)
	private Collection<IIOTRoleModel> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Collection<IIOTRoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Collection<IIOTRoleModel> roles) {
		this.roles = roles;
	}

	public IIOTUserModel(String userName, String userPassword, String userType, String userStatus,
			Collection<IIOTRoleModel> roles) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userStatus = userStatus;
		this.roles = roles;
	}
	
	public IIOTUserModel() {
		
	}
	
}
