package vnua.fita.springboot.store.form;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vnua.fita.springboot.store.utils.Constant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
	@NotBlank(message = Constant.ErrorMessageUserValidation.NOT_BLANK_USERNAME)
	private String username;
	@Size(min = 6, max = 15, message = Constant.ErrorMessageUserValidation.PASSWORD_SIZE)
	private String password;
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
