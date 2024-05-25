package vnua.fita.springboot.store.service;

import vnua.fita.springboot.store.form.LoginForm;

public interface UserService {

	boolean checkLogin(LoginForm loginForm);
	
}
