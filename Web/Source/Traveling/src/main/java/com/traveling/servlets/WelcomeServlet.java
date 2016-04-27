package com.traveling.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeServlet {

    @RequestMapping("/home")
    public ModelAndView welcome() {
        ModelAndView view = new ModelAndView("home");
        return view;
    }

}
