package io.ridgway.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(final Model model) {
        model.addAttribute("test", "This value was set in the controller!");
        return "home/index";
    }

}
