package io.ridgway.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// A trailing slash is enforced in requests path comparisons
@Controller()
@RequestMapping("/another")
public class AnotherController {

    // A stand-alone slash is enforced in requests path comparisons (aka it expects /another/)
    @RequestMapping("")
    public String index(final Model model) {
        model.addAttribute("test", "This value was set in the OTHER!! controller!");
        return "another/index";
    }

    // Proceeding slashes are not needed here but harmless, trailing slashes are enforced
    @RequestMapping("page")
    public String page(final Model model) {
        return "another/page";
    }

}
