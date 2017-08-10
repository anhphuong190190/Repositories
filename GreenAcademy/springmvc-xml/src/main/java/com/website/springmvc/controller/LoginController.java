package com.website.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(method = RequestMethod.GET)
	public String login2(@RequestParam String userName, @RequestParam String password) {
		if ("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password))
			return "home";
		return "login";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestBody String userName, @RequestBody String password) {
		if ("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password))
			return "home";
		return "login";

	}
}