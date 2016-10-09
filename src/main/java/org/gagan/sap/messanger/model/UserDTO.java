package org.gagan.sap.messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDTO {

	private int userId;
	private String userName;
	private String password;
	private String apiKey;
	private Date dateOfBirth;
	private Date createdDate;
	private int versionId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
     

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	public UserDTO()
	{
		
	}

	public UserDTO(int userId, String userName, String password, String apiKey, Date dateOfBirth, Date createdDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.apiKey = apiKey;
		this.dateOfBirth = dateOfBirth;
		this.createdDate = createdDate;
	}
	

}