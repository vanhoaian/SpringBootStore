package vnua.fita.springboot.store.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User{

	private String username;
	private String password;
	private int role;

    public User(String userName, String password, int role) {
        this.username = userName;
        this.password = password;
        this.role = role;
    }
    
    public User() {
    	
    }

	public String getUsername() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
   
}