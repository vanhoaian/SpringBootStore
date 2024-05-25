package vnua.fita.springboot.store.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import vnua.fita.springboot.store.enity.User;
import vnua.fita.springboot.store.form.LoginForm;


@Service
public class UserServiceImp implements UserService{

	static List<User> users = Arrays.asList(
		    new User("user", "123", 0),
		    new User("admin", "123", 1),
		    new User("shipper", "123", 2)
		);
		
		@Override
		public boolean checkLogin(LoginForm loginForm) {
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

}
