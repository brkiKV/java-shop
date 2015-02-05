package org.java.shop.controller;

import javax.validation.Valid;

import org.java.shop.entity.User;
import org.java.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User construct() {
	return new User();
    }

    @RequestMapping("/users")
    public String users(Model model) {
	model.addAttribute("users", userService.findAll());
	return "users";
    }

    @RequestMapping("/users/{id}")
    public String detail(Model model, @PathVariable int id) {
	model.addAttribute("user", userService.findOne(id));
	return "user-detail";
    }

    @RequestMapping("/users/remove/{id}")
    public String deleteUser(@PathVariable int id) {
	userService.deleteOne(id);
	return "redirect:/users.html";
    }

    @RequestMapping("/register")
    public String showRegister() {
	return "user-register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") User user,
	    BindingResult result) {
	if (result.hasErrors()) {
	    return "user-register";
	}
	userService.save(user);
	return "redirect:/register.html?success=true";
    }

}
