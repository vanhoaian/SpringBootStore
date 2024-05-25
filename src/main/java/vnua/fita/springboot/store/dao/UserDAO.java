package vnua.fita.springboot.store.dao;

import java.util.Arrays;
import java.util.List;

import vnua.fita.springboot.store.enity.User;
import vnua.fita.springboot.store.form.LoginForm;

public class UserDAO {

	private String dfUsername;
	private String dfPassword;
	private int dfRole;
	
	public UserDAO()
	{
		
	}
	
	public UserDAO(String dfUsername, String dfPassword,int dfRole )
	{
		this.setDfUsername(dfUsername);
		this.setDfPassword(dfPassword);
		this.setDfRole(dfRole);
	}

	static List<User> users = Arrays.asList(
		    new User("user", "123", 0),
		    new User("admin", "123", 1),
		    new User("shipper", "123", 2)
		);

		public static boolean checkLogin(LoginForm loginForm) {
			boolean isSuccess = false;
			for (int i = 0; i < users.size(); i++) {

				User user = users.get(i);
				if (loginForm.getUsername().equals(user.getUsername())
						&& loginForm.getPassword().equals(user.getPassword())) {
					isSuccess = true;
					break;
				}
			}
			return isSuccess;
		}

	
	public String getDfUsername() {
		return dfUsername;
	}

	public void setDfUsername(String dfUsername) {
		this.dfUsername = dfUsername;
	}

	public String getDfPassword() {
		return dfPassword;
	}

	public void setDfPassword(String dfPassword) {
		this.dfPassword = dfPassword;
	}

	public int getDfRole() {
		return dfRole;
	}

	public void setDfRole(int dfRole) {
		this.dfRole = dfRole;
	}
	
	
}
