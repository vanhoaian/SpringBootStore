package vnua.fita.springboot.store.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import vnua.fita.springboot.store.dao.UserDAO;
import vnua.fita.springboot.store.form.LoginForm;


@Controller
@RequestMapping("")
public class MainController {
	@Autowired
	
	@GetMapping(value = { "/", "/home" })
	public String getHomePage(Model model,
			@CookieValue(value = "username") String username) {
		model.addAttribute("username", username);
		return "index";
	}

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		LoginForm loginForm = new LoginForm();
		model.addAttribute("message", null);
		model.addAttribute("loginForm", loginForm);
		return "login";
	}

	@PostMapping("/login")
	public String login(Model model, HttpServletResponse response,
			@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult) {
		boolean isSuccess = UserDAO.checkLogin(loginForm);

		if (bindingResult.hasErrors() || !isSuccess) {
			model.addAttribute("message", "Login failed");
			return "login";
		} else {
			Cookie cookie=new Cookie("username", loginForm.getUsername());
			cookie.setMaxAge(24*60*60);
			cookie.setSecure(true);
			cookie.setHttpOnly(true);
			
			response.addCookie(cookie);
			return "redirect:/";
		}
	}
}