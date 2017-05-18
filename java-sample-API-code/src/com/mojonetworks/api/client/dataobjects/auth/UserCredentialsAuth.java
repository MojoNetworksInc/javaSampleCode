/*
 * Name: UserCredentialsAuth.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: User credentials Authentication Object for Mojo Services - This is typically used for on-prem MWM service
 *
 */

package com.mojonetworks.api.client.dataobjects.auth;

public class UserCredentialsAuth extends AuthenticationInfo {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private final String type="usernamepasswordcredentials";

	public UserCredentialsAuth(String userName, String password) {
		setUsername(userName);
		setPassword(password);
	}

	public String getUsername() {
		return username;
	}
	private void setUsername(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "UserCredentialsAuth [username=" + username + ", password=" + password + ", type=" + type + "]";
	}

}
